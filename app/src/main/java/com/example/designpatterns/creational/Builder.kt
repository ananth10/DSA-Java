package com.example.designpatterns.creational

/**
 * BUILDER
 *
 * 1. Builder pattern is a creational pattern that separates the construction of a complex object from its representation so that
 * same construction process can create different representations. It is used when object has too many fields or its construction process is complex
 *
 * Complexity 2 out of 3 star
 * Popularity 3 out of 3
 *
 * The structure of Builder pattern typically includes:
 *
 * 1. Builder: An interface that defines the methods for building the parts of the complex object.
 * 2. ConcreteBuilder: A class that implements the Builder interface. It provides the implementation of the methods for building the parts of complex object and also
 * keep track of the constructed object.
 * 3. Director: A class that uses the Builder interface to construct an object. it defines the construction process but does not know the concrete classes of the Builder or the object being constructed.
 * 4. Product: A Complex object being constructed.
 *
 * In this example, ProductClass is the Complex object that being constructed. Builder is interface that defines methods for building the parts of complex object.
 * ConcreteBuilder is a class that implements the Builder interface and provide the implementation of the methods for building the parts of complex object.
 * Director is a class that uses Builder interface to construct an object and defines construction process
 *
 * The builder pattern is good for several reasons
 * 1. It allows to create different representations of same object: The Builder pattern allows to create different representations of same object, this can be very useful in situation
 * where the same object needs to be constructed in different ways.
 * 2. Its supports the Single Responsibility Principle: The Builder pattern separates the construction process of an object from its representation, this way
 * the class that defines the object only has to worry about the representation, and the Builder class only has to worry about construction process. this helps to adhere the SRP
 * */

class ProductClass {
    var partA: String = ""
    var partB: String = ""
    var partC: String = ""
}

interface Builder {
    fun buildPartA(part: String)
    fun buildPartB(part: String)
    fun buildPartC(part: String)
    fun getResult(): ProductClass
}

class ConcreteBuilder : Builder {
    private val product = ProductClass()

    override fun buildPartA(part: String) {
        product.partA = part
    }

    override fun buildPartB(part: String) {
        product.partB = part
    }

    override fun buildPartC(part: String) {
        product.partC = part
    }

    override fun getResult(): ProductClass {
        return product
    }

}

class Director {
    private lateinit var builder: Builder

    fun setBuilder(builder: Builder) {
        this.builder = builder
    }

    fun buildMinimalVariableProduct() {
        builder.buildPartA("part A")
    }

    fun buildFullFeatureProduct() {
        builder.buildPartA("part A")
        builder.buildPartB("part B")
        builder.buildPartC("part C")
    }
}

//Real time example

class User {
    var name: String = ""
    var email: String = ""
    var age: Int = 0
    var address: String = ""
    override fun toString(): String {
        return "User(name='$name', email='$email', age=$age, address='$address')"
    }

}

class UserBuilder() {
    private val user = User()

    fun name(name: String): UserBuilder {
        user.name = name
        return this
    }

    fun email(email: String): UserBuilder {
        user.email = email
        return this
    }

    fun age(age: Int): UserBuilder {
        user.age = age
        return this
    }

    fun address(address: String): UserBuilder {
        user.address = address
        return this
    }

    fun builder(): User {
        return user
    }
}

fun callSite1() {
    val user = UserBuilder().name("ananth")
        .email("aab@mail.com")
        .age(30)
        .address("home")
        .builder()

    println(user)
}