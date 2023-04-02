package com.example.myapplication.datastructures.array.codingminutes.sortings

import com.example.myapplication.joinToString

fun main(){
    val list = listOf(Pair(3, 4), Pair(2, 3), Pair(3, 7), Pair(1, 5), Pair(3, 4))
    val result = cartesianSort(list)
    println("RESULT::${result.joinToString(",")}")
}

fun cartesianSort(list:List<Pair<Int,Int>>):List<Pair<Int,Int>>{
    return list.sortedWith(specialSort())
}

fun specialSort() = Comparator<Pair<Int,Int>> { o1, o2 ->
    if(o1.first==o2.first){
        o1.second.compareTo(o2.second)
    }else{
       o1.first.compareTo(o2.first)
    }
}