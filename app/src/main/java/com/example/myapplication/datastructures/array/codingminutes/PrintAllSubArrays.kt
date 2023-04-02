package com.example.myapplication.datastructures.array.codingminutes

import com.example.myapplication.joinToString
import kotlin.math.max

fun main() {
    val array = intArrayOf(-2, 3, 4, -1, 5, -12, 6, 1, 3)
    printAllSubArrays(array)
    findMaxSubArraySum(array)
    findMaxSubArraySumUsingPrefix(array)
    findMaxSubArraySumUsingKadensApproach(array)
}

fun printAllSubArrays(array: IntArray) {
    for (i in array.indices) {
        for (j in i until array.size) {
            for (k in i..j) {
                print("${array[k]}")
            }
            println()
        }
    }
    println()
}

fun findMaxSubArraySum(array: IntArray) {
    var maxSum = 0
    for (i in array.indices) {
        for (j in i until array.size) {
            var currentSum = 0
            for (k in i..j) {
                print("${array[k]}")
                currentSum += array[k]
            }
            println()
            maxSum = max(currentSum, maxSum)
        }

        println("Max Sum::$maxSum")
    }
    println("Final Max Sum::$maxSum")
}

fun findMaxSubArraySumUsingPrefix(array: IntArray) {
    var maxSum = 0
    var prefixArray = Array(array.size){0}
    prefixArray[0] = array[0]
    for (i in 1 until array.size) {
        prefixArray[i] = prefixArray[i - 1].plus(array[i])
    }
    for (i in prefixArray.indices) {
        for (j in i until prefixArray.size) {
            var  currentSum = if(i>0)prefixArray[j].minus(prefixArray[i - 1]) else prefixArray[j]
            maxSum = max(currentSum, maxSum)
        }
    }
    println("Final Max Sum::$maxSum")
}

fun findMaxSubArraySumUsingKadensApproach(array: IntArray){
    var maxSum = 0
    var currentSum = 0

    for (i in array.indices){
        currentSum += array[i]
        if(currentSum<0){
            currentSum=0
        }
        maxSum = max(currentSum,maxSum)
    }

    println("Kadens Final Max Sum::$maxSum")
}
