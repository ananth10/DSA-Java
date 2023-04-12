package com.example.myapplication.datastructures.queue


fun main(){
  val queue  = Queue(4)
  queue.add(5)
  queue.add(7)
  queue.add(9)
  queue.add(11)
  queue.add(13)
  println("LIST::${queue.array.joinToString(",")}")
  queue.delete()
  println("LIST::${queue.array.joinToString(",")}")
    queue.delete()
    println("LIST::${queue.array.joinToString(",")}")
    queue.delete()
    println("LIST::${queue.array.joinToString(",")}")
    queue.delete()
    println("LIST::${queue.array.joinToString(",")}")
    queue.delete()
}

interface QueueOperations{
    fun add(value: Int)
    fun delete()
}
class Queue(length:Int):QueueOperations{
    var length = length
    var front = -1
    var rear = -1
    var array = arrayOfNulls<Int>(length).toMutableList()

    override fun add(value: Int) {
       if(rear==length-1){
           //queue is full
           return
       }
       if(front==-1 && rear==-1){
           front++
           rear++
           array[rear] = value
       }else{
           rear++
           array[rear] = value
       }

    }

    override fun delete() {
        var deletedItem:Int? = null
        if(front==-1){
            //queue is empty
        }
        if(front>=rear){
            front=-1
            rear=-1
        }
        println("FRONT::$front")
        array.removeAt(front)
//        front++
    }
}