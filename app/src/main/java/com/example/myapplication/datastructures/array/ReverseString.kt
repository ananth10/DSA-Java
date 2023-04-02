package com.example.myapplication.datastructures.array

fun main(){
  val item = reverseString("Ananth")
    println("REVERSED::$item")
}

fun reverseString(value:String):String{
    return if(value.isNullOrEmpty())
        "no values"
    else{
        var reversedString = StringBuilder()
        for (i in value.length-1 downTo 0){
            reversedString.append(value[i])
        }
        reversedString.toString()
    }
}