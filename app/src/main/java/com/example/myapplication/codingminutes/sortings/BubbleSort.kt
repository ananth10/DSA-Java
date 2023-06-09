package com.example.myapplication.codingminutes.sortings



fun main(){
    val array = intArrayOf(5,4,3,2,1)
    val result = bubbleSort(array)
    println("RESULT::${array.joinToString(",")}")
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