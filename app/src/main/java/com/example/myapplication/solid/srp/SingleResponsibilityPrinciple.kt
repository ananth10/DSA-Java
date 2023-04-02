package com.example.myapplication.solid.srp

//below sample is violation of SRP
/**
 * Order class has more than one responsibility which means it has more than one reason to make changes.
 * */
class Order{

    fun sendOrderUpdateNotification(){
        //sends notification about order updates to the user
    }

    fun  generateInvoice(){

    }

    fun save(){

    }
}

data class Order1(
    val id:Int,
    val name:String
)

//Create OrderNotificationSender which is responsible for sending notification updates to the user.

class OrderNotificationSender{
    fun sendNotification(order1: Order1){

    }
}

//Create OrderInvoiceGenerator which is responsible for generating the order invoice.

class OrderInvoiceGenerator{

    fun generateInvoice(order1: Order1){

    }
}

//create a OrderRepository which is responsible for storing the order in the database.

class OrderRepository{

    fun saveOrder(order: Order1){

    }
}

//Create OrderFacade, which delegates responsibility to the individual classes

class OrderFacade{
    private val orderNotificationSender : OrderNotificationSender?=null
    private val orderInvoiceGenerator : OrderInvoiceGenerator?=null
    private val orderRepository:OrderRepository?=null

    fun sendNotification(order: Order1){
        orderNotificationSender?.sendNotification(order)
    }

    fun invoiceGenerator(order: Order1){
        orderInvoiceGenerator?.generateInvoice(order)
    }

    fun saveOrder(order: Order1){
        orderRepository?.saveOrder(order)
    }
}

