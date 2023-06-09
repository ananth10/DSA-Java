package com.example.myapplication.codingminutes.stack.using_vector;

import java.util.Vector;

public class Stack<T> {

    Vector<T> vector = new Vector<>(10);
    public Stack() {

    }

    public void push(T data){
        vector.add(data);
    }

    public void pop(){
        vector.remove(vector.size()-1);
    }

    public T getTop(){
       return vector.get(vector.size()-1);
    }

    public boolean empty(){
        return vector.size()==0;
    }
}
