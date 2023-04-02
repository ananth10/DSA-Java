package com.example.myapplication.algorithm.sorting


/**
 * Radix sort is type of lexicographic sort
 * consider collection of tuples,lets say year and marks
 * (2016,10) (2016,8) (2015,8) (2015,9)
 * lets say we want to sort in ascending order of year and within each year we want sorted in ascending order of marks
 * output like below
 * 2015 8
 * 2015 9
 * 2016 8
 * 2016 10
 *
 * when sorting tuples with respect to first dimensional(2016) and second dimensional(10) and so on we call such sort as lexicographic sort
 *
 * year -> broad dimension
 * marks -> narrow dimension
 *
 * Sorting with respect to marks
 * (2016,8)(2015,8)(2015,9)(2016,10) , when is the same the order is going to be preserved, this called stable sort
 *
 * sorting with respect to years
 * (2015,8)(2015,9)(2016,8)(2016,10)
 *
 * Radix sort is also type of lexi sort in which stable sort is used, bucket sort will be used , this is the only specification
 *
 * Running Time For Radix Sort
 *
 * Bucket sort is order of O(N + n) N- Range, n- number of tuples it wants to sort,
 * We are going to call bucket sort d times, as  many times
 * above example there is 2 dimensions (2016(dimension1),8(dimension2))
 *
 * O(d(N+n)) because we are going to perform this algorithm d times.
 * */


fun main(){

}

fun radixSort(sequence:IntArray, range:Int) : IntArray{

//    for (i in d ---> i==1){
//        sequence = bucketSort(sequence,range,i)
//    }
    return sequence
}