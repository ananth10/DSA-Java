package com.example.myapplication.codingminutes.chars_strings

fun main(){
    val string = "hello5 im ananth10"
    val (space,digit,alpha) = findSpaceAndDigitAlpha(string)
    println("Space:$space, digit:$digit, alpha:$alpha")
    var arr = Array(10){element->{ println(element) }}
}

data class Props(val space:Int,val digit:Int,val alpha:Int)

fun findSpaceAndDigitAlpha(string: String):Props{
    var space=0
    var digit =0
    var alpha = 0

    for(i in string.indices){
        if(string[i] in 'a'..'z' || string[i] in 'A'..'Z'){
            alpha++
        }
        if(string[i].isDigit() && string[i].code in 48..57){
            digit++
        }
        if(string[i]==' '){
            space++
        }
    }
   return Props(space,digit,alpha)
}