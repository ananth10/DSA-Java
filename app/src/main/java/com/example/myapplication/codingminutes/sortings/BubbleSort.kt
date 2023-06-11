package com.example.myapplication.codingminutes.sortings



fun main(){
    val array = intArrayOf(5,4,3,2,1)
    val result = bubbleSort(array)
    val result1 = bubbleSort1(array)
    println("UNSORTED::${array.joinToString(",")}")
    println("SORTED::${result.joinToString(",")}")
    println("OPTIMISED SORTED::${result1.joinToString(",")}")
}

fun bubbleSort(array: IntArray):IntArray{
    val n = array.size
    for (i in 1 until n){
        for( j in 0 until n-i){
            if(array[j]>array[j+1]){
                var temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
    return array
}

//optimised approach - O(n)
fun bubbleSort1(array: IntArray):IntArray{
    val n = array.size
    for (i in 1 until n){
        var isSwapped = false;
        for( j in 0 until n-i){
            if(array[j]>array[j+1]){
                var temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
                isSwapped=true
            }
        }
        if(!isSwapped){
            break
        }
    }
    return array
}