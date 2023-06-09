package com.example.myapplication.codingminutes.array

import kotlin.math.abs

fun main(){
    var array = intArrayOf(2,4,6,8)
    val x =7
    val result = closetOfXPairSum(array,x)
    val result1 = closetOfXPairSumUsingBinaryApproach(array,x)
    println("PAIR::{${result.first},${result.second}}")
    println("PAIR::{${result1.first},${result1.second}}")
}

fun closetOfXPairSum(array: IntArray,x:Int) : Pair<Int,Int>{
    var leftIndex = 0
    var rightIndex = 0
    var temp = Int.MAX_VALUE

    for(i in array.indices){
        for(j in i+1 until array.size){
            if(abs((array[i]+array[j])-x) <temp){
                leftIndex = i
                rightIndex = j
                temp = abs(array[i]+array[j]-x)
            }
        }
    }

   return Pair(leftIndex,rightIndex)
}

fun closetOfXPairSumUsingBinaryApproach(array: IntArray,x:Int):Pair<Int,Int>{
    var leftIndex = 0
    var rightIndex = 0
    var temp = Int.MAX_VALUE
    var start=0
    var end = array.size-1

    while (end>start){
        if(abs(array[start]+array[end]-x)<temp){
            leftIndex = start
            rightIndex = end
            temp = abs(array[start]+array[end])
        }

        if(array[start]+array[end]>x){
            end--
        }
        else{
            start++
        }
    }

    return Pair(leftIndex,rightIndex)
}