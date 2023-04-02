package com.example.myapplication.algorithm.sorting


/**
 * Whats all fuss with sorting?
 *
 * TYPES Of SORTING ALGORITHM
 *
 * 1. Bubble sort
 * 2. Insertion sort
 * 3. Selection sort
 * 4. Merge sort
 * 5. Quick sort
 *
 *  ISSUES WITH sort()
 * */
fun main(){
    sortMe()
}


fun sortMe(){
    val letters: ArrayList<Char> = arrayListOf('a','d','m','c','p','l','f')
    val number: ArrayList<Int>   = arrayListOf(2,65,34,2,1,7,8)
    letters.sort()
    number.sort()
    println(letters.joinToString())
    println(number.joinToString())
}