package com.example.designpatterns.creational

/**
 * Prototype
 *
 * The Prototype pattern is a creational pattern that allows objects to be created by copying existing object
 * rather than creating new ones from the scratch. It is used when creating a new object is either expensive or impossible.
 *
 * Complexity 1 out of 3
 * Popularity 2 out of 3
 *
 * The structure of prototype pattern typically includes:
 *
 * 1. Prototype: An interface that defines clone method, which creates copy of object.
 * 2. ConcretePrototype: A class that implements the prototype interface. it provides the implementation of the clone() method.which creates the copy of object.
 * 3. Client: A class that uses the prototype interface to create new object
 *
 * Prototype pattern is good for several reasons
 *
 * 1. It reduces need for subclasses: When creating new objects based on existing ones, the Prototype pattern reduces the need for creating subclasses to instantiate new object, this can simplify the codebase
 * 2. It improve the performance: The Prototype pattern improves the performance by avoiding the overhead of creating a new object from scratch. instead it creates
 * a copy of an existing object, which can be faster and less memory-intensive.
 * 3. It allows for dynamic object creation: The Prototype pattern allows for dynamic object creation, this can be very useful when type of object is not known until run time.
 * */

interface Prototype {
    fun clone(): Prototype
}

class ConcretePrototype : Prototype {

    var attribute: String = ""
    override fun clone(): Prototype {
        val clone = ConcretePrototype()
        clone.attribute = this.attribute
        return clone
    }

}

class Client{
    fun operation(prototype: Prototype){
        val prototypeClone = prototype.clone()

        //uses the clone
    }
}