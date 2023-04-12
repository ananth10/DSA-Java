package com.example.myapplication.datastructures.queue


fun main() {
  val doubleEndedQueue=DoubleEndedQueue(4)
  doubleEndedQueue.addFront(5)
  doubleEndedQueue.addFront(6)
  doubleEndedQueue.addFront(7)
  doubleEndedQueue.addRear(8)
  println("LIST::${doubleEndedQueue.array.joinToString(",")}")
    println("${50%4}")
}

interface DQueueOperation {
    fun addFront(value: Int)
    fun addRear(value: Int)
    fun deleteFront()
    fun deleteRear()
}

class DoubleEndedQueue(length: Int) : DQueueOperation {
    var front = -1
    var rear = -1
    var length = length
    var array = arrayOfNulls<Int>(length).toMutableList()
    override fun addFront(value: Int) {
        if (rear == length - 1) {
            return
        }
        if(front==-1 && rear==-1){
            front++
            rear++
            array[front]= value
            return
        }else{
            if((rear+1)<length && array[rear+1]==null){
                for(i in rear downTo front){
                    array[i+1] = array[i]
                }
                array[front]=value
                rear++
            }
        }

        //another apporoach

        if (front==0){
            return //no space left
        }
        if(front==-1 && rear==-1){
            front++
            rear++
            array[front] = value
        }else{
            front--
            array[front]=value
        }
    }

    override fun addRear(value: Int) {
        if (rear == length - 1) {
            return
        }
        if (front == -1 && rear == -1) {
            front++
            rear++
            array[rear] = value
        } else {
            rear++
            array[rear] = value
        }
    }

    override fun deleteFront() {
      if(front==-1){
          return //nothing to delete
      }
      if(front==rear){
          front=-1
          rear=-1
          array.removeAt(front)
      }
      array.removeAt(front)
      front++
    }

    override fun deleteRear() {
        if(front==-1){
            return //nothing to delete
        }
        if(front==rear){
            front=-1
            rear=-1
            array.removeAt(rear)
        }
        array.removeAt(rear)
        rear--
    }


}
