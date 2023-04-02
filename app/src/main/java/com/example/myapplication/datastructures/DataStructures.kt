package com.example.myapplication.datastructures

import java.lang.StringBuilder

/**
 * Data Structures + Algorithms = Programs
 *
 * Data Structure is a way to organise data
 *
 * LIST OF DATA STRUCTURES
 * 1. Arrays
 * 2. LinkedList
 * 3. HashTables
 * 4. Stacks&Queues
 * 5. Trees
 * 6. Ties
 * 7. Graphs
 *
 * LIST OF ALGORITHMS
 *
 * 1. Sorting
 * 2. Dynamic Programming
 * 3. BFS+DFS Searching
 * 4. Recursion
 *
 * */

fun main(){
//    arrayThings()
//    reverseAString("Welcome")
    val array1 = arrayOf(3,8,4)
    val array2 = arrayOf(5,7,2)
    mergeArrayItems(array1,array2)
}

/**
 * Operations On DataStructures
 *
 * 1. Insertion
 * 2. Deletion
 * 3. Traversal
 * 4. Searching
 * 5. Sorting
 * 6. Access
 * */

/**
 * Arrays - Organises items sequentialy , one after another in memory.
 * Types - 1. static and dynamic arrays
 * 1. static array - Fixed in size, we need to specify number of elements.
 * 2. dynamic array - allows us to copy and rebuild array in new location
 * */

fun simpleArray(){
    val array = arrayOf("a","b","c","d"); // 4*4 = 16 bytes needed to store this array value.

    val accessedValue = array[2]  // access operation and Big O(1)

    array[3] = "t" // push value to array and Big O(1)

}

private fun arrayThings(){

    val array = MyArray()
    array.push("Hi")
    array.push("Hello")
    println("Array::${array.array.contentToString()}")
//    array.replace(0,"User")
//    array.pop(0)
    array.delete(0)
    array.push("Kpp")
    println("Array::${array.array.contentToString()}")
}

class MyArray(var capacity:Int = 1,var array: Array<String?> = arrayOfNulls(1), var length:Int = 0){

    fun get(index:Int) : String?{
        return if (index>-1 && index<length) array[index] else "IndexOutOfBounds"
    }

    fun push(item:String){
        if(length==capacity){
            val tempArray = arrayOfNulls<String>(2*capacity)
            for(i in array.indices){
                tempArray[i] = array[i]
            }
            array = tempArray
            capacity +=1
            println("capacity::$capacity")
        }
        array[length] = item
        length++
    }

    fun replace(index:Int, value:String){
        if(index>-1 && index<length){
            array[index] = value
        }else{
            println("arrayindexoutbound")
        }
    }

    fun pop(index:Int){
        if(index>0){
            length--
        }
    }

    fun delete(index: Int){
        println("Index::$index")
        println("Index::$length")
        if(index>-1 && index<length){
            if(index==length-1){
                println("length::${length-1}")
                pop(index)
            }else{
                println("cool::${array.size}")
                for (i in index until array.size-1){
                    println("item::${array[i+1]}")
                    array[i]=array[i+1]
                }
                length--
            }
        }else{
            println("arrayIndexBoundException")
        }
    }
}


fun reverseAString(value: String){

    if(!value.isNullOrEmpty()){
        var stringBuilder = StringBuilder()
        for (i in value.length-1 downTo  0){
            stringBuilder.append(value[i].toString())
        }
        println("Revered String is ${stringBuilder.toString()}")
    }
}


fun mergeArrayItems(array1:Array<Int>, array2:Array<Int>){
    var i= 0
    var j =0
    var k =0

    if(array1.isNotEmpty() && array2.isNotEmpty()){
        var array1Length:Int = array1.size
        var array2Length:Int = array2.size
        val totalLength = array1Length+array2Length
        val array3 = IntArray(totalLength)

        while (i<array1Length && j<array2Length){

            if(array1[i]<array2[j]){
                array3[k] = array1[i]
                i++

            }else{
                array3[k] = array2[j]
                j++
            }
            k++
        }

        while (i<array1Length){
            print("i: $i")
            array3[k] = array1[i]
            i++
            k++
        }

        while (j<array2Length){
            print("j: $j")
            array3[k] = array2[j]
            j++
            k++
        }
        println("Merged Array::${array3.contentToString()}")
    }


    fun mergeSortedArrays(arr1: IntArray, arr2: IntArray): IntArray {
        var i = 0
        var j = 0
        var k = 0

        val mergedArray = IntArray(arr1.size + arr2.size)

        while (i < arr1.size && j < arr2.size) {
            if (i<arr1.size||arr1[i] < arr2[j]) {
                mergedArray[k] = arr1[i]
                i++
            } else {
                mergedArray[k] = arr2[j]
                j++
            }
            k++
        }

//        while (i < arr1.size) {
//            mergedArray[k] = arr1[i]
//            i++
//            k++
//        }
//
//        while (j < arr2.size) {
//            mergedArray[k] = arr2[j]
//            j++
//            k++
//        }

        return mergedArray
    }
}