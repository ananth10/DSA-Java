package com.example.myapplication.datastructures.array.codingminutes.sortings

import java.util.Collections

fun main() {
    val array = intArrayOf(3, 1, 5, 2, 6)
    val flag = false
    val result = sortMe(array, flag)
    println("RESULT::${result}")

}

fun sortMe(array: IntArray, flag: Boolean): List<Int> {
    val list = array.toList()
    return list.sortedWith(compareMe(flag))
}

fun compareMe(flag: Boolean) = Comparator<Int> { a, b ->
    val flags = flag
    if (flags)
       a.compareTo(b)
    else
        b.compareTo(a)
}