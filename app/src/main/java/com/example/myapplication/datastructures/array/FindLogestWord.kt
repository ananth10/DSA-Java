package com.example.myapplication.datastructures.array

fun main(){
    var words = " I love you"
    val result = findLongestWord(words)
    println("Longest word is $result")
}

fun findLongestWord(words:String):String{
    val regWords = """[^a-zA-Z0-9\s]""".toRegex().replace(words,"").split(" ")
    var currentLongestWord = regWords[0]
    for (i in regWords){
        if(i.length>currentLongestWord.length){
            currentLongestWord=i
        }
    }

    return currentLongestWord
}