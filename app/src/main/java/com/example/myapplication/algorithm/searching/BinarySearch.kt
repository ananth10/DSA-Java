package com.example.myapplication.algorithm.searching

import kotlin.math.floor


/**
 * BINARY SEARCH
 *
 * -> Split list of sorted item and decide from there whether the item looking for is left or right the list, because list is sorted so we can comparing elements until keep going what we want
 * */

fun main(){

    val num = intArrayOf(1,3,5,7,13,24,56,58,65)
    val index = binarySearch(num,1,0,num.size-1)
    println("FOUND :$index")
}

fun binarySearch(numbers:IntArray,searchElement: Int,start:Int,end:Int):Int{
        val middle = (start+end)/2

        if(numbers[middle]==searchElement){
            return middle;
        }

        if(start==end){
            return -1
        }
        if(numbers[middle]<searchElement){
            return binarySearch(numbers,searchElement,middle+1,end)
        }

        if(numbers[middle]>searchElement){
            return binarySearch(numbers,searchElement,start,middle-1)
        }
    return -1
}