package com.example.myapplication.datastructures.queue

import com.example.myapplication.joinToString

fun main() {
    val cq = CircularQueue<Int>(2)
    cq.add(2)
    cq.add(4)
    cq.add(5)
    println("List::${cq.array.joinToString(",")}")
    cq.delete()
    println("List::${cq.array.joinToString(",")}")
    cq.delete()
    println("List::${cq.array.joinToString(",")}")
}

interface CircularQueueOperations<T> {
    fun add(value: T)
    fun delete()
}

class CircularQueue<T>(length: Int) : CircularQueueOperations<T> {
    var length = length
    var front = -1
    var rear = -1
    val array = arrayOfNulls<Int>(length).toMutableList()

    override fun add(value: T) {
        if (rear - front == length - 1 || front - rear == 1) { //check queue is full or not
            return
        }
        if (front == -1) {
            front++
            rear++
            array[rear] = value as Int
            return
        } else {
            rear++
            rear %= length
            array[rear] = value as Int
            return
        }
    }

    override fun delete() {
      if(front==-1){
          return //queue is empty
      }
      if(rear==front){
          array.removeAt(front)
          rear=-1
          front=-1
          return
      }else{
          front++
          front %= length
          array.removeAt(front)
      }
    }

}