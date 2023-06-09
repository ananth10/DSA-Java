package com.example.myapplication.codingminutes.hashtable;

public class HashNode<T> {
    public String key;
    public T value;
    public HashNode<T> next;

    public HashNode(String key, T value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
