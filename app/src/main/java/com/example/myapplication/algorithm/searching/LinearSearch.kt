package com.example.myapplication.algorithm.searching


/**
 * ->Linear search takes 2 input , one is array and data element
 * ->travers through the array and check whether given element is contain in that array or now
 * */
fun main(){
  val num = intArrayOf(7,8,4,2,1)
  val index = search(num,4)
  print(index)
}


fun search(num:IntArray,element:Int):Int{
    for(i in num.indices){
        if(num[i]==element){
            return i
        }
    }
    return -1
}