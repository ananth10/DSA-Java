package com.example.myapplication.codingminutes.two_dimen_array


fun main(){
    pascalTriangle(2)
}
fun pascalTriangle(n: Int) {
    var number: Int
    for (i in 0..n) {
        number = 1
        var j = 0
        while (j <= i) {
            print("$number ")
            number = number * (i - j) / (j + 1)
            j++
        }
        println()
    }
}