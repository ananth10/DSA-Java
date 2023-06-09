package com.example.myapplication.codingminutes.chars_strings

fun main() {
    val input = charArrayOf('a', 'a', 'b', 'b', 'b', 'c', 'c','d')
    val result = compressString(input)
    println("$result")
}

fun compressString(input: CharArray): Int {
    var count = 1
    var output = StringBuilder()
    var i = 0
    while (i < input.size) {
        while (i < input.size - 1 && input[i + 1] == input[i]) {
            count++
            i++
        }
        output.append(input[i])
        if (count == 1) {
            i++
            continue
        }
        output.append(count)
        count = 1
        i++
    }
    println(output)
    return output.length
}