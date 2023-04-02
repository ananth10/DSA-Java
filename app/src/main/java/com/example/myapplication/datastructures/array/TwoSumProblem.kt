package com.example.myapplication.datastructures.array

fun main(){
    val input = intArrayOf(2,7,11,15)
    val target = 9
//    val result = findIndicesOfTwoSumToTheTarget(input,target)
//    val result2 = findIndicesOfTwoSumToTheTarget(input,target)
//    println(result.joinToString(","))
//    println(result2.joinToString(","))
    val result3 = approachTwo(input,target)
    println(result3.joinToString(","))

    val result4 = approachThree(input,target)
    println(result4.joinToString(","))
}

//brute force approach one
fun findIndicesOfTwoSumToTheTarget(array:IntArray, target: Int):IntArray{
    for(i in array.indices){

        for (j in array.indices){
            if(array[i]+array[j]==target){
                return intArrayOf(i,j)
            }
        }
    }
    return intArrayOf()
}

//brute force approach two
fun findIndicesOfTwoSumToTheTarget2(array:IntArray, target: Int):IntArray{
    for(i in array.indices){

        for (j in i+1 until array.size-1){
            if(array[j]==target-array[i]){
                return intArrayOf(i,j)
            }
        }
    }
    return intArrayOf()
}

//Two-Pass hash table approach

fun approachTwo(array:IntArray, target:Int):IntArray{
  var map:MutableMap<Int,Int> = mutableMapOf()
  for(i in array.indices){
      map[array[i]] = i
  }

  for(i in array.indices){
      val complement = target-array[i]
      if(map.containsKey(complement) && map[complement]!=i){
          return intArrayOf(i,map.get(complement)?:0)
      }
  }
 return intArrayOf()
}

//One-Pass hash table

fun approachThree(array: IntArray,target: Int):IntArray {
    var map: MutableMap<Int, Int> = mutableMapOf()
    for (i in array.indices) {
        val complement = target - array[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map.get(complement) ?: 0, i)
        }
        map.put(array[i], i)
    }
    return intArrayOf()
}