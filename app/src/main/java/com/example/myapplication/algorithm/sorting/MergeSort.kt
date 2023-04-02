package com.example.myapplication.algorithm.sorting

import kotlin.math.floor


/**
 * MERGE SORT
 * -> Merge sort is sorting algorithm and it uses divide and conquer method to sort elements of array/list and merge sort is one of the most efficient way to sort the list
 * ->Divide given array
 * ->Sorted it using merge sort
 * ->Merge is using merge function
 * -> O(n log n)
 **/

fun main() {
//    val numbers = listOf(4, 5, 1, 7)
    val array = intArrayOf(4, 5, 1, 7, 2)
//    val result = mergeSort(numbers)
    val result1 = mergeSort1(array)
    println("result::${result1.joinToString(",")}")
}


fun mergeSort(number: List<Int>): List<Int> {
    if (number.size == 1) {
        return number
    }
    val middleIndex = floor((number.size / 2).toDouble())
    var left: List<Int> = mergeSort(number.subList(0, middleIndex.toInt()))
    val right: List<Int> = mergeSort(number.subList(middleIndex.toInt(), number.size))
    println("I::${left}}")
    println("I::${right}")
    return merge(left, right)
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    println("LEFT::${left}}")
    println("RIGHT::${right}}")
    val result: MutableList<Int> = ArrayList()
    var leftIndex = 0
    var rightIndex = 0
    while (leftIndex < left.size && rightIndex < right.size) {
        if (left[leftIndex] < right[rightIndex]) {
            result.add(left[leftIndex])
            leftIndex++
        } else {
            result.add(right[rightIndex])
            rightIndex++
        }
    }
    val remainingLeft: List<Int> = left.subList(leftIndex, left.size)
    val remainingRight: List<Int> = right.subList(rightIndex, right.size)
    result.addAll(remainingLeft)
    result.addAll(remainingRight)
    println("RESULT::${result}}")
    return result
}


fun mergeSort1(array: IntArray): IntArray {
    println("LEFT::${array.joinToString(",")}}")
    if (array.size == 1) {
        return array
    }
    val middle = array.size / 2
    val leftSubArray = mergeSort1(array.sliceArray(0 until middle))
    val rightSubArray = mergeSort1(array.sliceArray(middle until array.size))
    return merge1(leftSubArray, rightSubArray)
}

fun merge1(leftArray: IntArray, rightArray: IntArray): IntArray {
    var leftIndex = 0
    var rightIndex = 0
    var mergedArray: MutableList<Int> = mutableListOf()
    while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
            mergedArray.add(leftArray[leftIndex])
            leftIndex++
        } else {
            mergedArray.add(rightArray[rightIndex])
            rightIndex++
        }
    }

    for (i in leftIndex until leftArray.size) {
        mergedArray.add(leftArray[i])
    }
    for (j in rightIndex until rightArray.size) {
        mergedArray.add(rightArray[j])
    }
    return mergedArray.toIntArray()
}
