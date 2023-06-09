package com.example.myapplication.codingminutes.chars_strings

fun main(){
    val value = "abba"
    val result = isPassedWordPalindrome(value)
    println("$result")
}

fun isPassedWordPalindrome(value:String):Boolean{
    var start =0
    var end = value.length-1
    var mid:Int = start+end/2
    while (start<=mid){
        if(value[start] != value[end]){
            return false
        }
        start++
        end--
    }
    return true
}