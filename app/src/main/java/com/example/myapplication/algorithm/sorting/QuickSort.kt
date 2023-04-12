package com.example.myapplication.algorithm.sorting




/**
 * QUICK SORT
 * ->Quick sort is like merge sort, like divide and conquer but using pivot concept
 * ->Quick sort is an algorithm to sort an array of numbers, when we can say sorted array is every number in that array should be in correct position.
 * ->We say element in correct position if every numbers which appears to left of that element is less than that element and every number which appears to right of that element is greater than that element, if this condition is apply to every element in array, we say array has been sorted.
 *
 * */
fun main() {
    val numbers = intArrayOf(7, 1, 3, 5, 2, 6, 4)
    val result = qs(numbers, 0, numbers.size - 1)
    println("LIST::${result.joinToString(",")}")
}


fun quickSort(numbers: IntArray, start: Int, end: Int): List<Int> {
    if (start < end) {
        val pivotIndex = partition(numbers, start, end)
        quickSort(numbers, start, pivotIndex - 1)
        quickSort(numbers, pivotIndex + 1, end)
    }

    return numbers.toList()
}

/**
 * Partition algorithm returns pivot index
 * */
fun partition(numbers: IntArray, start: Int, end: Int): Int {
    var pivotIndex: Int = start
    var pivot = numbers[end]
    for (i in start until end) {
        if (numbers[i] <= pivot) {
            //swap numbers[pivotIndex] with numbers[i]
            val temp = numbers[pivotIndex]
            numbers[pivotIndex] = numbers[i]
            numbers[i] = temp
            pivotIndex++
        }
    }
    //swap numbers[pivotIndex] with numbers[end]
    val temp = numbers[pivotIndex]
    numbers[pivotIndex] = numbers[end]
    numbers[end] = temp

    return pivotIndex
}

fun qs(array:IntArray,start:Int,end:Int):IntArray{
    if(start<end){
        var pivot = parti(array,start,end)
        qs(array,start,pivot-1)
        qs(array,pivot+1,end)
    }
    return array
}

fun parti(array:IntArray,start: Int,end: Int):Int{
    var pivot = array[end]
    var pi = start

    for(i in start until end-1){
        if(array[i]<=pivot){
            var temp = array[i]
            array[i] = array[pi]
            array[pi] = temp
            pi++
        }
    }

    var temp = array[pi]
    array[pi] = array[end]
    array[end] = temp
    return pi
}