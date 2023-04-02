package com.example.myapplication.algorithm.dynamicprog


/**
 * ->Dynamic programming is optimization technique using cache.
 * ->Dynamic programming is way to solve the problem by breaking it to down into collection of sub-problems, so sub-problem is storing solution in cache for the nect time.
 * */
fun main(){

    println(memoizedAddTo80(5))
    println(memoizedAddTo80(5))
    println(memoizedAddTo80(6))
    println(fibonacciMaster(8))
}

fun addTo80(number:Int):Int{
    return number+80
}

/**
 * Memoization is a specific form of caching that involved caching the returned value only function that is return value of this function based on the parameters and if the parameter of this function does not change it memoize
 * Memoization is simply say to
 * */

var cache:MutableMap<Int,Int> = mutableMapOf()

fun memoizedAddTo80(number:Int) : Int? {
    if(cache.isNotEmpty()) {
        for (key in cache) {
            return if (number == key.key) {
                cache[number]
            } else {
                println("taking long time")
                cache[number] = number + 80
                cache[number]
            }
        }
    }else{
        println("taking long time")
        cache[number] = number + 80
       return cache[number]
    }
    return -1
}

var fiboCache:MutableMap<Int,Int?> = mutableMapOf()

fun fibonacciMaster(number:Int): Int? {
   println(fiboCache)
    return if (fiboCache.containsKey(number)) {
        fiboCache[number]
    } else {
        if(number<2){
            number
        }else {
            fiboCache[number] = fibonacciMaster(number - 1)?.plus(fibonacciMaster(number - 2)!!)
            fiboCache[number]
        }
    }

}

