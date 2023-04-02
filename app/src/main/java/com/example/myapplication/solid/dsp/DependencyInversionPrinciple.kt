package com.example.myapplication.solid.dsp

/**
 * The Dependency Inversion Principle state that the most flexible systems are those in which code dependencies refer only to abstractions, not to concretions
 * */

open class ClassA{

    fun doSomething(){

    }
}

class ClassB:ClassA(){

    fun doInt(){
        val classA = ClassA() //ClassB needs an object of classA in order to work properly, we can say that ClassA depends on ClassB, with help of DIP we can inverse this dependency
        classA.doSomething()
    }
}

//We need to invest dependency between ClassA and ClassB
//An example where classes are depends on each other

class EmailNotification{

    fun sendNotification(message:String){

    }
}

class NotificationService{

    fun sendNotification(message: String){
        val emailNotification = EmailNotification() //NotificationService depends on EmailNotification class, we can say EmailNotification depends on NotificationService
        emailNotification.sendNotification(message)
    }
}

fun main(){
    val notificationService = NotificationService()
    notificationService.sendNotification("Hii") //NotificationService depends on EmailNotification to send the notification, here dependency comes
}

//Solution

interface Notification{

    fun sendNotification(message: String)
}

class EmailNotification1:Notification{

    override fun sendNotification(message: String) {
     println("Sending email Notification:$message")
    }

}

class SmsNotification:Notification{

    override fun sendNotification(message: String) {
        println("Sending SMS Notification:$message")
    }

}

class NotiService{

     var notification:Notification?=null

    fun sendNotification(message: String){
        notification?.sendNotification(message)
    }
}

fun main1(){
    val message = "Happy coding"
    val notiService=NotiService()
    var notification : Notification

    notification = EmailNotification1()
    notiService.notification = notification
    notiService.sendNotification(message)

    notification = SmsNotification()
    notiService.notification = notification
    notiService.sendNotification(message)

}

//Now NotiService depends on Notification Interface rather than concrete class

/**
SRP — Each software module should have one, and only one, reason to change.

OCP — Software systems should be easy to change, they must be designed to allow the behavior of those systems to be changed by adding new code, rather than changing the existing code.

LSP — To build a software system from interchangeable parts, those parts must adhere to a contract that allows those parts to be substituted one for another.

ISP — Software designers should avoid depending on the things they don’t use.

DIP — The code that implements high-level policy should not depend on low-level details.
 * */