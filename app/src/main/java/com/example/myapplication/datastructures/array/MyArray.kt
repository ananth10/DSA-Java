package com.example.myapplication.datastructures.array


fun main(){
    val array = MyArray()
    array.push("A")
    array.push("B")
    println("value:${array.get(0)}")
    println("All Item::${array.size()}")
    array.delete(0)
    println("All Item::${array.size()}")
}
class MyArray {

    private var array = arrayOfNulls<String>(1)
    private var currentLength:Int=0
    private var capacity:Int =1


    fun get(index:Int):String{
        if(index in 0 until currentLength){
            return array[index]?:""
        }
        return "Index Out Of Bound"
    }

    fun push(value:String){
        if(capacity==currentLength){
           var tempArray = arrayOfNulls<String>(capacity*2)
            for(index in array.indices){
                tempArray[index] = array[index]
            }
            array=tempArray
            capacity*=2
        }
        array[currentLength]=value
        currentLength++
    }

    fun pop(){
        if(currentLength>0){
            currentLength--
        }
    }

    fun delete(index:Int){
      if(index in 0 until currentLength-1){
          if(index==currentLength){
              pop()
          }else{
             for(i in index until currentLength-1){
                 array[i] = array[i+1]
             }
              currentLength--
          }
      }else{
          println("Out of bounds")
      }
    }

    fun size():Int{
        return currentLength
    }
}