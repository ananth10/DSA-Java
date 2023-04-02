package com.example.designpatterns.creational

/**
 * Abstract Factory
 *
 * 1. The Abstract Factory pattern is Creational pattern that provides an interface for families of related or dependent objects without specifying the concrete class.
 * It uses a set of factory methods, each of which creates a related object of specific class.
 *
 * Complexity 2 out of 3 start
 * Popularity 3 out of 3
 *
 * The structure of abstract factory pattern includes:
 *
 * 1. AbstractFactory: An interface that defines the factory methods for creating objects, Those methods return objects of the Product interface
 * 2. ConcreteFactory: Classes that implements the AbstractFactory interface, These classes provides the implementation of AbstractFactory methods, creating object of ConcreteProduct classes.
 * 3. Product: An interface that defines the type of objects that will be created by the factory methods.
 * 4. ConcreteProduct: Classes the implement the Product interface. These classes define the specific type of object that will be created by the ConcreteFactory classes
 *
 * The AbstractFactory pattern is closely related to FactoryMethod pattern, The main difference is that the factory method creates objects of a single class.
 * while abstract factory creates the object of multiple classes. The abstract factory pattern provides way to encapsulate a group of individual factories that have a common theme.
 * without specifying the their concrete classes.
 * */

//AbstractFactory

interface AbstractFactory {
    fun createProductA(): ProductA
    fun createProductB(): ProductB
}

//ConcreteFactory

class ConcreteProductA1 : ProductA {
    override fun use() {

    }

}

class ConcreteProductA2 : ProductA {
    override fun use() {

    }

}

class ConcreteProductB1 : ProductB {
    override fun use() {

    }

}

class ConcreteProductB2 : ProductB {
    override fun use() {

    }

}

//Product

interface ProductA {
    fun use()
}

interface ProductB {
    fun use()
}

//ConcreteProduct

class ConcreteFactory1 : AbstractFactory {
    override fun createProductA(): ProductA {
        return ConcreteProductA1()
    }

    override fun createProductB(): ProductB {
        return ConcreteProductB1()
    }

}

class ConcreteFactory2 : AbstractFactory {
    override fun createProductA(): ProductA {
        return ConcreteProductA2()
    }

    override fun createProductB(): ProductB {
        return ConcreteProductB2()
    }

}

//Real world example

interface AlertDialog {
    fun show()
}

class MaterialAlertDialog : AlertDialog {

    override fun show() {
        println("Material dialog")
    }

}

class CupertinoAlertDialog : AlertDialog {
    override fun show() {
        println("Cupertino dialog")
    }

}

interface DialogFactory {
    fun createAlertDialog(): AlertDialog
}

class MaterialDialogFactory : DialogFactory {
    override fun createAlertDialog(): AlertDialog {
        return MaterialAlertDialog()
    }

}

class CupertinoDialogFactory : DialogFactory {
    override fun createAlertDialog(): AlertDialog {
        return CupertinoAlertDialog()
    }

}

class DialogFactoryProvider {
    companion object {
        fun getDialogFactory(factoryType: String): DialogFactory? {
            return when (factoryType) {
                "material" -> MaterialDialogFactory()
                "cupertino" -> CupertinoDialogFactory()
                else -> null
            }
        }
    }
}

fun callSite(){
    val materialDialogFactory = DialogFactoryProvider.getDialogFactory("material")
    val materialAlertDialog = materialDialogFactory?.createAlertDialog()
    materialAlertDialog?.show()


    val cupertinoDialogFactory = DialogFactoryProvider.getDialogFactory("cupertino")
    val cupertinoAlertDialog = cupertinoDialogFactory?.createAlertDialog()
    cupertinoAlertDialog?.show()


}