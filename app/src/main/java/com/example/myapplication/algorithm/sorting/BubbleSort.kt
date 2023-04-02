package com.example.myapplication.algorithm.sorting

import java.sql.Array
import android.R.array





/**
 * BUBBLE SORT
 * ->bubble sort works like bubble up highest number
 * ->bubble sort is one of the simplest algorithm and less efficient
 * -> TIME - O(n^2)
 * ->SPACE - 0(1)
 * */
fun main(){

  val numbers = intArrayOf(99,44,2,1,5,63,87,283,4,0)
      bubbleSort(numbers)
    val result = bubbleSort1(numbers)
    println("sorted list::${result.joinToString(",")}")
}


fun bubbleSort(numbers:IntArray){
    for (i in numbers.indices) {
        for (j in 0 until numbers.size - 1) {
            if (numbers[j] > numbers[j + 1]) {
                val temp: Int = numbers[j]
                numbers[j] = numbers[j + 1]
                numbers[j + 1] = temp
            }
        }
    }
    println(numbers.contentToString())
}

fun bubbleSort1(array:IntArray):IntArray{
    var n = array.size
    var temp: Int

    for(i in n-1 downTo 1){
        for(j in 0 until i){
            if(array[j]>array[j+1]){
                temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }

    return array
}