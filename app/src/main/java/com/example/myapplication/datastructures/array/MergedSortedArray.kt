package com.example.myapplication.datastructures.array

fun main(){
 val array1 = arrayOf(0,2,5,7)
 val array2 = arrayOf(1,3,4,6)
 mergedSortedArray(array1,array2)
}

fun mergedSortedArray(array1:Array<Int>,array2:Array<Int>){
 var i =0
 var j =0
 var k =0

 var meregedArray = arrayOfNulls<Int>(array1.size+array2.size)

 while (i < array1.size && j < array2.size) {
  if (array1[i] < array2[j]) {
   meregedArray[k] = array1[i]
   i++
  } else {
   meregedArray[k] = array2[j]
   j++
  }
  k++
 }

 while (i<array1.size){
  meregedArray[k] = array1[i]
  i++
  k++
 }

 while (i<array2.size){
  meregedArray[k] = array2[i]
  j++
  k++
 }

 println(meregedArray.joinToString(","))

}