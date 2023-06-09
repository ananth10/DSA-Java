package com.example.myapplication.codingminutes.sortings

fun main(){
    val array = intArrayOf(1,2,3,4,5)
    val result = insertionSort(array)
    println("RESULT::${result.joinToString(",")}")
}

fun insertionSort(array: IntArray):IntArray{
   val n = array.size
    var current: Int
    var previous: Int

   for (i in 1 until n) {
       current = array[i]
       previous = i-1

       while (previous>=0 && array[previous]>current){
           array[previous+1] = array[previous]
           previous -= 1
       }
       array[previous+1] = current
   }
    return array
}