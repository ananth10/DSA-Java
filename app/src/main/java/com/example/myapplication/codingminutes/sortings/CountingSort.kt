package com.example.myapplication.codingminutes.sortings

import kotlin.math.max


fun main() {
    val array = intArrayOf(5, 4, 3, 2, 1, 1)
    val result = countingSort(array)
    println("REST:${result.joinToString(",")}")
}

fun countingSort(array: IntArray): IntArray {
    var largestValue: Int = -1
    for (i in array.indices) {
        largestValue = max(array[i],largestValue)
    }

    val counterArray = Array(largestValue + 1) { 0 }
    for (i in array.indices) {
        counterArray[array[i]] = counterArray[array[i]] + 1
    }
    var j = 0
    for (i in counterArray.indices) {
        while (counterArray[i] > 0) {
            println("$i")
            array[j] = i
            counterArray[i] = counterArray[i] - 1
            j++
        }
    }
    return array
}