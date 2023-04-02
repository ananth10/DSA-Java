package com.example.designpatterns.creational

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/**
 * Singleton
 *
 * Singleton pattern is creational pattern that ensures class has only one instance and provides a global access point to this instance. its used
 * when a single instance of class needs to coordinate actions cross the system.
 *
 * Complexity 1 out of 3
 * Popularity 2 out of 3
 *
 * The structure of Singleton pattern includes:
 *
 * 1. Singleton: A class that implements the singleton pattern, it has private constructor and static instance variable that holds single instance of tha class
 * and it also has static method often its called getInstance() that return the single instance of the class.
 *
 * Singleton pattern is good for several reasons:
 *
 * 1. It Improves performance : By reusing the same instance of class , the Singleton pattern can improve performance by avoiding the overhead of creating new object.
 * 2. It controls concurrent access: The Singleton pattern can be used to control concurrent access to a shared resources, this is useful in situations where multiple threads trying to access same resources simultaneously
 * 3. It helps to maintain the state of object: by keep in on reference.
 * */

class Singleton private constructor() {
    companion object {
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!
        }
    }
}

//Real world example

class DatabaseHelper private constructor(context:Context){
    companion object{
        private var instance:DatabaseHelper?=null

        fun getInstance(context: Context):DatabaseHelper{
            if(instance==null){
                instance = DatabaseHelper(context)
            }
            return instance!!
        }
    }

    private val database: SQLiteDatabase = context.openOrCreateDatabase("app_db", Context.MODE_PRIVATE,null)

    fun executeQuery(query:String){
        database.execSQL(query)
    }

    fun getData(query: String):Cursor{
        return database.rawQuery(query,null)
    }
}

fun useSite(){
//    val databaseHelper  = DatabaseHelper.getInstance(context)
//    val cursor = databaseHelper.getData("SELECT * FROM users")
}