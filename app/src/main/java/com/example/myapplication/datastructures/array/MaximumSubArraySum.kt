package com.example.myapplication.datastructures.array

import com.example.myapplication.max
import kotlin.math.abs

fun main(){
    val array = intArrayOf(5,4,-6,7,8,-8,-2)
//    val array1 = intArrayOf(2, 3, 4, 5, 7)
//    val maxSum = bruteForceApproachOne(array)
//    println(maxSum)
//
//    val maxSum1 = bruteForceApproachTwo(array)
//    println(maxSum1)

//    var list = listOf("aa",2,false)
//    println(list)
//
//    for(count in 5..5){
//        println(count)
//    }

    //approach three

//    val maxSum3 = maxSubArraySum(array,0,array.size-1)
//    println(maxSum3)

//    val approach4 = maxSubarraySum(array,array.size)
//    println(approach4)

    val approach5 = findMaxSumSubArray(array)
    println(approach5)

    val approach6 = findMaxSubArraySum(array)
    println(approach6)
}

//approach 1
fun bruteForceApproachOne(array: IntArray): Int{
    var maxSum = 0
    for(i in array.indices){
        for(j in i until array.size){
            var sum = 0
            for(k in i until j){
                sum += array[k]
                if(sum>maxSum)
                    maxSum = sum
            }
        }
    }
return maxSum
}

//approach 2
fun bruteForceApproachTwo(array: IntArray):Int{
    var maxSum = 0
    for (i in array.indices){
        var sum =0
        for( j in i until array.size){
            sum+=array[j]
            if(sum>maxSum){
                maxSum=sum
            }
        }
    }
    return maxSum
}

//approach 3 - brute force
fun maxSubArraySum(number:IntArray, start:Int, end:Int):Int{

    if(start>end){
        return Int.MIN_VALUE
    }
    if(start==end){
        return number[start]
    }

    val mid = (start+end)/2
    val leftSubArray = maxSubArraySum(number,start,mid)
    println("leftSubArray::$leftSubArray")
    val rightSubArray = maxSubArraySum(number,mid+1,end)
    println("rightSubArray::$rightSubArray")
    val crossingSum = maxCrossingSum(number,start,mid,end)
    println("crossingSum::$crossingSum")

    return Math.max(Math.max(leftSubArray,rightSubArray),crossingSum)
}

fun maxCrossingSum(number: IntArray,start:Int,mid:Int,end:Int):Int{
    println("Start::$start")
    println("mid::$mid")
    println("end::$end")
    var sum = 0
    var leftSum = Int.MIN_VALUE

    for(i in mid downTo start){
        sum += number[i]
        if(sum>leftSum){
            leftSum = sum
        }
    }

    sum = 0
    var rightSum = Int.MIN_VALUE

    for (i in mid..end){
        sum+=number[i]
        if(sum>rightSum){
            rightSum = sum
        }
    }

    return Math.max(leftSum+rightSum-number[mid],Math.max(leftSum,rightSum))
//    return Math.max(leftSum,rightSum)
}

//approach 4 - divide & conquer

fun maxSubarraySum(number:IntArray, n:Int):Int{
    val maxEndingHere = intArrayOf(n)
    maxEndingHere[0] = number[0]

    for(i in 1 until n){
        if(number[i] + maxEndingHere[i-1] > 0){
            maxEndingHere[i] = number[i] + maxEndingHere[i-1]
        }else{
            maxEndingHere[i] = number[i]
        }
    }

    var answer = 0

    for(i in 0 until n){
        answer = Math.max(answer,maxEndingHere[i])
    }
    return answer
}

//Approach 5 Kadane's algorithm

fun findMaxSumSubArray(number:IntArray):Int{
    var maxCurrent = number[0]
    var maxGlobal = number[0]

    for(i in 1 until number.size){
        maxCurrent = Math.max(number[i],maxCurrent+number[i])
        if(maxCurrent>maxGlobal){
            maxGlobal = maxCurrent
        }
    }

    return maxGlobal
}

//Approach 6

fun findMaxSubArraySum(number:IntArray):Int{
    var sum = number[0]
    var answer = number[0]

    for (i in 1 until  number.size){
        if(number[i]+sum<0){
            sum = 0
        }else{
            sum+=number[i]
            answer = Math.max(sum,answer)
        }
    }

    return answer

}
