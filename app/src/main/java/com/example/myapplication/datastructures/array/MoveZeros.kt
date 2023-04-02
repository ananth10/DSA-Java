package com.example.myapplication.datastructures.array

fun main(){
   val array = intArrayOf(0,1,0,3,12)
    var result = moveZeros(array)
    println(result.joinToString())

    var result1 = moveZeros2()
    println(result1.joinToString())
}

//Approach 1

fun moveZeros(numbers:IntArray): Array<Int?> {
    var tempArray = arrayOfNulls<Int>(numbers.size)
    var count = 0
    for(i in numbers.indices){
        if(numbers[i]!=0){
            tempArray[count] = numbers[i]
            count++
        }
    }

    for (i in count until numbers.size){
        tempArray[i] = 0
    }

    return tempArray
}

//approach 2 without creating temp array
fun moveZeros2(): Array<Int> {
    var numbers = arrayOf(0,1,0,3,12)
    var index = 0

    for(i in numbers.indices){
        if(numbers[i]!=0){
            numbers[index++] = numbers[i]
        }
    }

    while (index<numbers.size){
        numbers[index++] = 0
    }

    return numbers
}