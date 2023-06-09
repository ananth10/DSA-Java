package com.example.myapplication.codingminutes.array

fun main() {
    val array = arrayOf(1, 6, 14, 16, 22, 24, 26, 33, 35, 44)
    val result = binarySearch(array, 3)
    println("RESULT::$result")
}

fun binarySearch(array: Array<Int>, key: Int): Int {
    var start = 0
    var end = array.size - 1

    while (start <=end) {
        var mid = (start + end) / 2
        if (array[mid] == key) {
            return mid
        } else if (key < array[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    return -1
}