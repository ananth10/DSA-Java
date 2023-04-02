package com.example.myapplication.datastructures.array

fun main() {
    val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7)
    val result = rotateArray(numbers)
    val result2 = rotateArray2(numbers, count)
    val numbers1 = arrayOf(1, 2, 3, 4, 5, 6, 7)
     rotateArray3(numbers1, 3)
//    println("Result::${result2.joinToString()}")
}
/**
 * Rotate the array for the given times e.g k=3
 * */
fun rotateArray(numbers: Array<Int>): Array<Int?> {
    val k = 7
    var index = 0
    var tempArray = arrayOfNulls<Int>(numbers.size)
    for (i in numbers.size-k until numbers.size) {
      tempArray[index++]=numbers[i]
    }
    for (i in 0 until numbers.size-k) {
        tempArray[index++]=numbers[i]
    }
    return tempArray
}

//approach 2
var count = 0
fun rotateArray2(numbers: Array<Int>,count:Int):Array<Int>{
    if(count==3)
        return numbers
    val lastValue = numbers[numbers.size-1]
    for (i in numbers.size-1 downTo 1){
         numbers[i] = numbers[i-1]
    }
    numbers[0] = lastValue
    val count1 = count+1
    return rotateArray2(numbers,count1)
}

//Approach 3
fun rotateArray3(numbers: Array<Int>, k:Int){
    var kdivo = k%numbers.size
    reverse(numbers,0,numbers.size-1)
    reverse(numbers,0,kdivo-1)
    reverse(numbers,kdivo,numbers.size-1)
    println("Result::${numbers.joinToString()}")
}

fun reverse(numbers: Array<Int>, start:Int, end:Int){
    var _start = start
    var _end = end
    while (_start<_end){
//        println("numbers::${numbers.joinToString()}")
//        println("start::${numbers[_start]}")
        val temp = numbers[_start]
        numbers[_start++] = numbers[_end]
        numbers[_end--] = temp
    }
}

