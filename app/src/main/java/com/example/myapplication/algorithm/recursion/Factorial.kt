package com.example.myapplication.algorithm.recursion



/**
 *
 * 5! = 5*4*3*2*1 => 120
 * The pattern of sequence is  that
 * */

fun main(){
//   val fact = findFactorialUsingRecursive(5)
//   val fact1 = findFactorialUsingIterative(5)
//   print(fact)
//   print(fact1)
   val result = reverseString("ananth")
    println(result)
}

/**
 * Find a factorial using recursive function
 *
 * e.g 5! = 5*4*3*2*1
 * */


fun findFactorialUsingRecursive(number:Int):Int{
    if(number==2){
        return 2
    }
    return  number * findFactorialUsingRecursive(number-1)
}


/**
 * Fina a factorial using iterative function
 * */

fun findFactorialUsingIterative(number: Int):Int{
    var fact = 1
    if(number==2){
        return 2
    }
    for (i in 2 until number+1) {
        fact *= i
    }
   return fact
}

fun reverseString(value:String):String{
    val length = value.length
    val chars = value.toCharArray()
    var reversed =""
    if(length==0){
        return reversed
    }
    reversed = chars[length-1].toString()
    return reversed + reverseString(value.substring(0,length-1))
}