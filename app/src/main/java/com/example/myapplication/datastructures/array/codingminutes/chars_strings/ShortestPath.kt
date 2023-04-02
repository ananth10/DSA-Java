package com.example.myapplication.datastructures.array.codingminutes.chars_strings

fun main(){
    var route = "SNNNEWE"
    val result = findShortestPath(route)
    println(result)
}

fun findShortestPath(route:String):String{
    var x=0
    var y=0

    for(i in route.indices){
        when(route[i]){
            'S'->y--
            'N'->y++
            'E'->x++
            'W'->x--
        }
    }

    var path = StringBuilder()
    if(x>=0 && y>=0){
        while (y!=0){
            y--
            path.append('N')
        }

        while (x!=0){
            x--
            path.append('E')
        }
    }
    else if(x<=0 && y>=0){
        while (y!=0){
            y--
            path.append('N')
        }

        while (x!=0){
            x++
            path.append('W')
        }
    }
    else if(x<=0 && y<=0){
        while (y!=0){
            y++
            path.append('S')
        }

        while (x!=0){
            x++
            path.append('W')
        }
    }else{
        while (y!=0){
            y++
            path.append('S')
        }

        while (x!=0){
            x--
            path.append('E')
        }
    }
    return  path.toString()
}