package com.example.designpatterns.creational

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 1. The Factory method pattern is a creational design pattern that provides an interface for creating objects in a superclass but allow subclasses to be alter
 * the type of objects that will be created.
 * 2. It defines a method for creating objects, which subclass can then override to change the type of objects that will be created.
 *
 * complexity 1 out of 3 star
 * popularity 3 out of 3 star
 *
 * The structure of factory method pattern includes:
 * 1. Product: an interface or abstract class that defines the type of objects that will be created. this interface or class defines the methods
 * that all objects created by the factory method must implement.
 *
 * 2. ConcreteProduct: Classes that implement the Product interface or inherit from the abstract Product class .
 * These classes define the specific type of objects that will be created by the factory method.
 *
 * 3. Creator: An abstract class or interface that defines the factory method. This class or interface defines the method that subclasses will use to create objects.
 *
 * 4. ConcreteCreator: Classes the implement the Creator interface or inherit from the abstract Creator class.
 * These classes provide the implementation of the factory method and determine the specific type of object that will be created.
 * */

interface Product {
    fun use()
}

class ConcreteProductA : Product {
    override fun use() {
        TODO("Not yet implemented")
    }

}

class ConcreteProductB : Product {
    override fun use() {
        TODO("Not yet implemented")
    }

}

abstract class Creator {
    abstract fun factoryMethod(): Product

    fun someOperation() {
        val product = factoryMethod()
        product.use()
    }
}

class ConcreteCreatorA : Creator() {

    override fun factoryMethod(): Product {
        return ConcreteProductA()
    }

}

class ConcreteCreatorB : Creator() {
    override fun factoryMethod(): Product {
        return ConcreteProductB()
    }

}

//Real world example

interface RetrofitApi {
    fun create(): Retrofit
}

class ProductionRetrofitApi : RetrofitApi {
    override fun create(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("prod url")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}

class StagingRetrofitApi : RetrofitApi {
    override fun create(): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("stage url")
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}

class RetrofitApiFactory() {
    companion object {
        fun createRetrofitApi(apiType: String): RetrofitApi? {
            return when (apiType) {
                "prod" -> ProductionRetrofitApi()
                "stage" -> StagingRetrofitApi()
                else -> null
            }
        }
    }
}

fun useEx(){
    val prod = RetrofitApiFactory.createRetrofitApi("prod")?.create()
    val stage = RetrofitApiFactory.createRetrofitApi("stage")?.create()
}

/**
 * The Factory method pattern is good for several reasons.
 *
 * 1. It promotes loose coupling: By encapsulating the process for creating objects in a separate factory class ,
 * it allows client code to remain unaware of specific classes that are being instantiated, promoting loose coupling between  the client code and object it uses
 *
 * 2. It allows for easy modification: Because the factory method is defined in an interface or abstract class it can be easily overridden by subclasses to change the type of object that are created.
 * this makes it easy to modify the code to create different types of objects without affecting the client code.
 *
 * 3. It allows for code reuse: By encapsulating the process of creating objects in a separate factory class, it allows for code reuse across multiple classes, this can lead to more organized and efficient codebase.
 *
 * 4. It simplifies the object creation: By encapsulating the process of creating objects in a factory class, it can simplify the creation of objects in factory class, it can simplify
 * the creation of complex object.
 *
 * 5. It supports Open-Closed Principle:  The Factory Method pattern allows new objects to be added to the system without modifying existing client code,
 * it supports the open-closed principle which states that classes should be open for extension but closed for modification.

 * */