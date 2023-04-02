package com.example.myapplication.datastructures


fun main(){
//    operationOnHashTable()
//    findFirstRecurringNumber();
    findFirstRecurredNumber()
}

/**
 * Hash Table - Used to store object, like key and value. and key is passed to Hash function and it hash it and store it in memory address.
 * Insert - O(1)
 * Delete - O(1)
 * Lookup - O(1)
 * Search - O(n)
 * */

/**
 * Hash Function - Hash Function is simply a function that generates value of fixed length for each input that it gets
 * */

class HashTable(var size:Int){

    var data = IntArray(size)

    fun hash(key:String) :Int{
        var hash =0
        for(i in key.indices){
            hash = (hash+key[i].toInt()*i) % data.size
        }
        return hash
    }

    fun set(key:String, value:Int){
        var address = hash(key)
        data[address] = value

        println("DATA::${data.contentToString()}")
    }

    fun get(key:String):Int{
        var address = hash(key)
        println("GET::${data[address]}")
        return data[address]
    }
}

fun operationOnHashTable(){
    var hashTable = HashTable(2)
    hashTable.set("apple",100)
    hashTable.set("orange",300)
    hashTable.set("cool",400)
    hashTable.get("apple")
}

/** Find first recurring character or number in given array*/

fun findFirstRecurringNumber(){
    val array = arrayOf(2,5,5,2,4,1,7,8)
    println("First recurring number is ${recursionFun(array)}")
}

fun recursionFun(array: Array<Int>) : Int{
   var map = mutableMapOf<Int,Int>()
    for(i in array){
        if(map[i]==i){
           return i
        }else{
            map[i]=i
        }
    }
    return -1
}

fun findFirstRecurredNumber(){
    val array = arrayOf(2,5,5,2,4,1,7,8)
    var leastRecurredPosition=array.size-1
    for(i in 0 until array.size-1){
        for (j in i+1 until array.size-1){
            if(array[i]==array[j]){
               if(j<leastRecurredPosition){
                   leastRecurredPosition=j
                   println("leastRecurredPosition::$leastRecurredPosition")
               }
            }
        }

    }
    val result = array[leastRecurredPosition]
    println("FUN::"+result)
}
