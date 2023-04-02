package com.example.myapplication.algorithm.recursion


/**
 * 0,1,1,2,3,5,8,13,21,34,55,89,144.....
 *
 * The pattern of the sequence is that each value is the sum of the 2 previous values, that means N->5 = 2+3
 * */
fun main(){
   val fibo = fibonacciUsingRecursion(8)
   val fibo1 =  fibonacciUsingIterative(8)
    println(fibo)
    println(fibo1)
}


/**
 * O(n)
 * */
fun fibonacciUsingIterative(number: Int) : Int{
    var arr = arrayListOf(0,1)
    for (i in 2 until number+1){
     arr.add(arr[i-1]+arr[i-2])
    }
    return arr[number]
}

/**
 * O(2^n) Exponential - recursive algorithms that solve a problem of size N
 * */

fun fibonacciUsingRecursion(number:Int): Int{
    if(number<2){
        return number
    }
    return fibonacciUsingRecursion(number-1) + fibonacciUsingRecursion(number-2)
}