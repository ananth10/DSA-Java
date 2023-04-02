package com.example.myapplication.datastructures.array

fun main() {
    var numbers = arrayOf(1,5, 2, 3, 4,9)
    val result = isArrayContainsDuplicateElements(numbers)
    val result1 = isDuplicate(numbers)
    println("Is array contains duplicate values:$result")
    println("Is array contains duplicate values:$result1")
}

fun isArrayContainsDuplicateElements(numbers: Array<Int>): Boolean {

    var map: MutableMap<Int, Int> = mutableMapOf()

    for (i in numbers.indices) {
        if (map.containsKey(numbers[i])) {
            var currentCount = map[numbers[i]] ?: 0
            map[numbers[i]] = currentCount + 1
        } else {
            map[numbers[i]] = 1
        }
    }

    for ((_, value) in map) {
        if (value > 1) {
            return true
        }
    }
    return false
}

//approach 2
 fun isDuplicate(numbers: Array<Int>):Boolean{
     var hashSet:MutableSet<Int> = mutableSetOf()
    for(i in numbers.indices){
        if(hashSet.contains(numbers[i])){
            return true
        }
        hashSet.add(numbers[i])
    }
    return false
 }