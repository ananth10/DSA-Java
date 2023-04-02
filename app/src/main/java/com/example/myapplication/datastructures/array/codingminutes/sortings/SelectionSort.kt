package com.example.myapplication.datastructures.array.codingminutes.sortings

fun main(){
    val array = intArrayOf(4,2,1,3,5)
    val result = selectionSort(array)
    println("RESULT::${result.joinToString(",")}")
}

fun selectionSort(array: IntArray):IntArray{

    for (i in 0 until array.size-2){
        var minPos = i
        for (j in i until array.size){
            if(array[j]<array[minPos]){
                minPos=j
            }
        }
        val currentElement = array[i]
        array[i] = array[minPos]
        array[minPos] = currentElement
    }
    return array
}