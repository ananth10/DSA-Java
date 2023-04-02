package com.example.myapplication.algorithm.searching.linearsearch

fun main(){
    val array:Array<Int> = arrayOf(1,3,5,6,40)
    val result = linearSearch(array.toIntArray(),5)
    println("$result")
}

fun linearSearch(array: IntArray,target:Int):Int{
    for(i in array){
        if(i==target){
            return i
        }
    }
    return -1
}