package com.example.myapplication.algorithm


/**
 * Whats is recursion??
 * A function refers to itself inside of that function
 *
 * ANYTHING YOU DO WITH A RECURSION CAN BE DONE ITERATIVELY (loop)
 *
 *  RECURSION          vs          ITERATIVE
 *  1. DRY
 *  2. READABLE
 *  3. LARGE STACK
 *
 *  WHEN TO USE RECURSION
 *
 *  -> When we working on tree or using tree or converting something into tree
 *  -> Usually we use recursion in divide and conquer
 *
 * */
var counter=0
fun main(){
//    println(callMe())

    println(findNumber(6))
}

fun callMe() : String{
    if(counter>3) {   //Identified base case
       return "done"
    }
    counter++
    return callMe()  //Identified recursive case
}

fun findNumber(num:Int):Int{
    if(num==1){
        return 1
    }

    return 1 + findNumber(num-1)
}