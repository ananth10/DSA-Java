package com.example.myapplication.algorithm.searching.binarysearch

import kotlin.math.floor

fun main(){
    val array = intArrayOf(1,5,10,15,34,56,65,60,78,90)
    val result = binarySearch(array,1,0,array.size-1)
    println("RESULT::$result")

}

fun binarySearch(array: IntArray,target:Int,start:Int,end:Int):Int{

    val middle = floor(((start+end)/2).toDouble()).toInt()
    if(array[middle]==target){
        return middle
    }
    if(start==end){
        return -1
    }
    if(array[middle]<target){
        return binarySearch(array,target,middle+1,end)
    }
    if(array[middle]>target){
        return binarySearch(array,target,start,middle-1)
    }
    return -1
}