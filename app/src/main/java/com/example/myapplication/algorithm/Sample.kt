package com.example.myapplication.algorithm

fun main(){
    val nemoArray = arrayOf("cool", "case","apple","run","organge","volvo","tension","welcome","nemo")
    val bigArray = (1..100000)
//    findNemo(nemoArray) // O(n) --> Linear Time, because this function do number of operation e.g if size is 1 then it will do one operation and if size is 2 then it will 2 operations , here operation is checking equals.
//    findFirstElement(nemoArray)// O(1) --> Constant Time, because this function is going to do one operation that if index is 0 then it will print(one operation) even if array has 10k elements.
//    runBigNumber(bigArray)
//    nestedLoop(); // O(n*n) = O(n^2) --> Quadratic Time
//    printAllNumbersThenAllPairsSum()

    val array = arrayOf(6,4,3,2,1,7)
    hasPairWithSum(array,9)
}

fun findNemo(nemoArray: Array<String>) {
   val t1 = System.currentTimeMillis();
    for(nemo in nemoArray){
        if(nemo == "nemo"){
            println("Found nemo")
        }
    }
    val t2 = System.currentTimeMillis();

    println("Time took: ${t2-t1}")
}

fun findFirstElement(nemoArray: Array<String>){
    for((index,value) in nemoArray.withIndex()){
           if(index==0) {
               println("Found nemo $value")
           }
    }
}

fun runBigNumber(bigList: IntRange){
    val t1 = System.currentTimeMillis();
    for(i in bigList){
            println("Found nemo $i")
    }
    val t2 = System.currentTimeMillis();

    println("Time took: ${t2-t1}")
}

fun nestedLoop(){
    val array = arrayOf('a','b','c','d','e','f')
    for (letter in array){   // Big O(n)
        for (letter1 in array){  // Big O(n)
            println("output: $letter,$letter1")
        }
    }
}

fun printAllNumbersThenAllPairsSum(){
    val luckyNumbers = arrayOf(1,2,3,4,5)
    println("These are the numbers:")
    for (num in luckyNumbers){    //O(n)
        println("$num")
    }
    println("These are their sums:")
    for (num in luckyNumbers){  //O(n^2)
        for (num1 in luckyNumbers){
            println("${num+num1}")
        }
    }

    // Big O(n+n^2) // Drop non dominants(which means n), so Big O(n^2)
}

/**
 * 3 pillars of good code
 * 1. Readability
 * 2. Time Complexity
 * 3. Space Complexity
 * */

/**
 * Big O Complexity Rules
 * 1. Worst Case
 * 2. Remove Constants
 * 3. Different terms for inputs
 * 4. Drop non dominants
 * */

/**
 * What causes space complexity
 * 1. Variables
 * 2. Data Structures
 * 3. Function call
 * 4. Allocations
 * */

/**
 * Data Structures
 * 1. Arrays
 * 2. Stacks
 * 3. Queues
 * 4. Linked List
 * 5. Trees
 * 6. Tries
 * 7. Graphs
 * 8. Hash Tables
 * */

/**
 * Algorithms
 * 1. Sorting
 * 2. Dynamic Programming
 * 3. BFS + DFS Searching
 * 4. Recursion
 * */


/**
 * QUESTION 1 - Does pair of array add sum up to 9
 * SUM - 9
 * ARRAY[6,4,3,2,1,7]
 * */

fun hasPairWithSum(array : Array<Int>, sum:Int) : Boolean{
    val set = mutableSetOf<Int>()

    for (num in array){

        if(set.contains(num)){
            return true
        }
        set.add(sum-num)
    }

    print(set)
    return false

}
