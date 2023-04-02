package com.example.myapplication.solid.ocp

import android.Manifest.permission_group.SMS

/**
 * Class or interface should be open for extension and closed for modification
 * */

/**
 * Violation of OCP example
 * */
//violation of OCP

enum class NotificationTypes{
    PUSH_NOTIFICATION,
    EMAIL
}

class NotificationService{

    fun sendNotification(notificationTypes: NotificationTypes){
        when(notificationTypes){
            NotificationTypes.EMAIL ->{
              //send email notification
            }
            NotificationTypes.PUSH_NOTIFICATION ->{
                //send push notification
            }
        }
    }
}

//Now, lets a i get a new requirement to support SMS notification, so i need to modify NotificationTypes enum class and NotificationService class

//enum class NotificationTypes{
//    PUSH_NOTIFICATION,
//    EMAIL,
//    SMS
//}
//class NotificationService{
//
//    fun sendNotification(notificationTypes: NotificationTypes){
//        when(notificationTypes){
//            NotificationTypes.EMAIL ->{
//                //send email notification
//            }
//            NotificationTypes.PUSH_NOTIFICATION ->{
//                //send push notification
//            }
//            NotificationTypes.SMS ->{
//
//            }
//        }
//    }
//}

/**
 * Solution to the OCP violation
 * */

interface Notification{
    fun sendNotification()
}

class PushNotification : Notification{

    override fun sendNotification() {

    }

}

class EmailNotification:Notification{
    override fun sendNotification() {

    }

}

class SMSNotification:Notification{
    override fun sendNotification() {

    }

}

//NotificationServices class follows OCP, now we can add/remove different types of notification without modifying NotificationServices class
class NotificationServices(){

    fun sendNotification(notification: Notification){
        notification.sendNotification()
    }
}

fun testOcp(){
    val notificationServices: NotificationServices = NotificationServices()
    val smsNotification:SMSNotification = SMSNotification()

    notificationServices.sendNotification(smsNotification)

}