package com.example.myapplication.datastructures.array.codingminutes.chars_strings

fun main(){
    val input = "aeoibsddaeioudb"
    val result = findVowelsInGivenString(input)
    println(result)
}

fun findVowelsInGivenString(input: String): String {
  val vowels = "aeiou"
  var i = 0
  var length = input.length
  val builder = StringBuilder()

  while (i<length){
      if(vowels.contains(input[i])){
          builder.append(input[i])
      }
      i++
  }
    return builder.toString()
}

