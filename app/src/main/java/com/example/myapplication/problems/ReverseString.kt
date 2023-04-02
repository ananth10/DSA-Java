package com.example.myapplication.problems

fun main(){
    var input = charArrayOf('h','e','l','l','o')
    println(input)
    reverseString(input)

    var input1 = intArrayOf(2,2,1,3,3,5,5)
    findUniqueElement(input1)

    var input2 = intArrayOf(0,1,0,3,12)
    moveZeros(input2)
}

fun reverseString(s:CharArray){
    var result = CharArray(s.size)
    for(index in s.size-1 downTo 0){
        result[(s.size-1)-index] = s[index]
    }
    println(result)
}

fun findUniqueElement(array: IntArray){
    var mutableMap : MutableMap<Int,Int?> = mutableMapOf()
    for (a in array){
        if(mutableMap.containsKey(a)){
            mutableMap[a] = mutableMap[a]?.plus(1)
        }else{
            mutableMap[a] = 1
        }
    }
    println(mutableMap.filterValues { it==1 }.values)

}

fun moveZeros(numbers:IntArray){
    //0,1,0,3,12
    var count =0
    for(i in numbers.indices){
        if(numbers[i]!=0){
            numbers[count++] = numbers[i]
        }
    }
    while (count<numbers.size){
        numbers[count++] =0
    }
    println(numbers.contentToString())

}
