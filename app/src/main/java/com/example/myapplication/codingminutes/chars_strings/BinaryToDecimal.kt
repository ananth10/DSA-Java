package com.example.myapplication.codingminutes.chars_strings

fun main(){
    val input = "111"
    val result = com.example.myapplication.codingminutes.chars_strings.convertBinaryToDecimal(input)
    println(result)
}

fun convertBinaryToDecimal(input: String): Int {
    val length  = input.length
    var decimal = 0
    var base = 1

    for (i in length-1 downTo 0){
        if(input[i] == '1') {
            decimal += base
        }
        base *= 2
    }
    return decimal
}
