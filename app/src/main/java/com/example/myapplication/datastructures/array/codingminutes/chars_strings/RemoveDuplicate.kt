package com.example.myapplication.datastructures.array.codingminutes.chars_strings

import android.os.Build.VERSION_CODES.P

fun main(){
    val str = "geeksforgeeks"
    val result = removeDuplicateChar(str)
    println(result)
}

fun removeDuplicateChar(str:String):String{
    var i = 0
    var length = str.length
    var builder = StringBuilder()

    while (i<length){
        if(!builder.contains(str[i])){
            builder.append(str[i])
        }
        i++
    }
    var sortedChars = builder.toString().toCharArray().sorted()
    var sortedString= StringBuilder()
    for (j in sortedChars.indices){
        sortedString.append(sortedChars[j])
    }
    return sortedString.toString()
}