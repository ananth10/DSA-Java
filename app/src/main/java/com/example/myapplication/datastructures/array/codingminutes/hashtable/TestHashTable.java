package com.example.myapplication.datastructures.array.codingminutes.hashtable;

public class TestHashTable {

    public static void main(String[] args){
        HashTable<Integer> table = new HashTable<>(10);
        table.insert("Mango",40);
        table.insert("Apple",50);
        table.insert("Orange",30);
        table.print();
        int value = table.search("Mango");
        System.out.println("VAL:"+value);
        table.erase("Apple");
        table.print();
    }
}
