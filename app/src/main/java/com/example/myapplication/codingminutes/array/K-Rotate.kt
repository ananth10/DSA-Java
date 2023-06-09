package com.example.myapplication.codingminutes.array

fun main(){
    val array = intArrayOf(1,2,3,4,5,6)
    val k = 3
    val result = rotateKTimes(array,k)
    val result1 = anotherApproach(array,k)
    println("RESULT::${result.joinToString(",")}")
    println("RESULT::${result1.joinToString(",")}")
}

fun rotateKTimes(array: IntArray,times:Int):IntArray{
    var count = 0

    while (count<times){
        var temp = array.last()
        for (i in array.size-1 downTo 1){
            array[i] = array[i-1]
        }
        array[0] = temp
        count++
    }

    return array
}

fun anotherApproach(array: IntArray,k:Int):IntArray{
    var n  = array.size
    var k = k%n
    var rotatedArray = intArrayOf(n).toMutableList()

    for (i in array.indices){
        if(i<k){
            rotatedArray.add(array[n+i-k])
        }else{
            rotatedArray.add(array[i-k])
        }
    }
    return rotatedArray.toIntArray()
}