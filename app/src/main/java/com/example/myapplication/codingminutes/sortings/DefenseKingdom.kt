package com.example.myapplication.codingminutes.sortings

import kotlin.math.max


fun main(){
    val width = 15
    val height = 8
    val towerPositions = listOf(Pair(3,8), Pair(11,2),Pair(8,6))
    val result = findUndefendedLargestCells(towerPositions,width,height)
    println("RESULT::$result")
}

fun findUndefendedLargestCells(towerPosition:List<Pair<Int,Int>>,width:Int,height:Int):Int{
    var xPos  = mutableListOf<Int>()
    var yPos = mutableListOf<Int>()
    var maxX = Int.MIN_VALUE
    var maxY = Int.MIN_VALUE

    for(i in towerPosition.indices){
        xPos.add(towerPosition[i].first)
        yPos.add(towerPosition[i].second)
    }

    xPos.sort()
    yPos.sort()

    for(i in 1 until xPos.size){
        maxX = max(maxX,xPos[i]-xPos[i-1]-1)
    }

    for (j in 1 until yPos.size){
        maxY = max(maxY,yPos[j]-yPos[j-1]-1)
    }
    println("X::$maxX")
    println("Y::$maxY")
    println("XX SIZE::${xPos.size}")
    println("YY SIZE::${yPos.size}")
    println("XX::${xPos[xPos.size-1]}")
    println("YY::${yPos[yPos.size-1]}")

    maxX = max(maxX,width-xPos[xPos.size-1])
    maxY = max(maxY,height-yPos[yPos.size-1])
    return maxX*maxY
}