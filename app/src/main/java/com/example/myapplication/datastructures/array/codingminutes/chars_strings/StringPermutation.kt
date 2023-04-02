package com.example.myapplication.datastructures.array.codingminutes.chars_strings

fun main() {
    val a = "test"
    val b = "test"
    val result = checkPermutation(a, b)
    val result1 = arePermutation(a,b)
    println(result)
    println(result1)
}

fun checkPermutation(a: String, b: String): Boolean {
    var aMap: MutableMap<Char, Int> = mutableMapOf()
    var bMap: MutableMap<Char, Int> = mutableMapOf()
    var i = 0
    var j = 0
    val aLength = a.length
    val bLength = b.length

    while (i < aLength) {
        if (aMap.containsKey(a[i])) {
            val value = aMap.getValue(a[i])
            aMap[a[i]] = value + 1
        } else {
         aMap[a[i]] = 1
        }
        i++
    }
    while (j < bLength) {
        if (bMap.containsKey(b[j])) {
            val value = bMap.getValue(b[j])
            bMap[b[j]] = value + 1
        } else {
            bMap[b[j]] = 1
        }
        j++
    }

    println("$aMap")
    println("$bMap")
    return aMap == bMap
}

//naive approach

fun arePermutation(str1:String,str2:String):Boolean{

    if(str1.length!=str2.length) //if length is not equal then it should not be the permutation
        return false

    str1.toCharArray().sort()
    str2.toCharArray().sort()

    return str1 == str2
}