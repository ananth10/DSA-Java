package com.example.myapplication.codingminutes.chars_strings

fun main(){
    var char:CharArray = charArrayOf('a','b','c')
    println("${char.joinToString(",")}")

    for(i in char.indices){
        println("${char[i]}")
    }
    var byte:Byte = 123
    println("$byte")
}