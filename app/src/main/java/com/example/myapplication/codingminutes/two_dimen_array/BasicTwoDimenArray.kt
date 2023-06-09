package com.example.myapplication.codingminutes.two_dimen_array

fun main(){
    val row = intArrayOf(1,2,3)
    val column = intArrayOf(1,2)
    val array = arrayOf(row,column)

    for (i in array){
        println(i.contentToString())
    }
}