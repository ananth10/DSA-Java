package com.example.myapplication.codingminutes.array



fun main(){
    val array = intArrayOf(1, 2, 3, 4, 6,8,9)
    val result = lowerBound1(array,6)
    println("LOWER BOUND::$result")
}

fun lowerBound(array: IntArray, value:Int):Int{
    var lowerBound = 0
    var smallestElement=array[0]
    for (i in array.indices){
        if(array[i]==value){
            return array[i]
        }
       if(array[i]<value){
           if(array[i]>lowerBound){
               lowerBound=array[i]
           }
       }
        if(array[i]<smallestElement){
            smallestElement=array[i]
        }
    }
    if(value<smallestElement)
        return -1

    return lowerBound
}

fun lowerBound1(array: IntArray,value: Int):Int{
    var l = 0
    var r = array.size-1
    var answer = -1

    while (l<=r){
        var mid = (l+r)/2
        if(array[mid]>value){
            r = mid-1
        }else{
            answer = array[mid]
            l=mid+1
        }
    }
    return answer
}