package com.example.myapplication.datastructures.array.codingminutes.hashtable;

import java.util.ArrayList;

public class HashTable<T> {

    ArrayList<HashNode<T>> table;
    int cs;
    int ts;

    public HashTable(int defaultSize) {
        cs = 0;
        ts = defaultSize;
        table = new ArrayList<>(ts);

        //add null for all entries
        for (int i = 0; i < ts; i++) {
            table.add(null);
        }
    }

    private int hashFunction(String key) {
        int index = 0;
        int power = 1;
        for (int i = 0; i < key.length(); i++) {
            Character ch = key.charAt(i);
            index = (index + power * ch) % ts; //dividing with table size to avoid overlap, so index will fall within table size
            power = (power * 29) % ts; //dividing with table size to avoid overlap,  so index will fall within table size
        }

        return index;
    }

    private void rehash() {
        //save old table and we will do insertion in new table
        ArrayList<HashNode<T>> oldTable = table;
        int oldTs = ts;

        //increase table size
        cs = 0;
        ts = 2 * ts + 1; //mostly bring size to prime
        table = new ArrayList<>(ts);
        //add null for all entries
        for (int i = 0; i < ts; i++) {
            table.add(null);
        }

        //copy elements from old table into new table
        for (int j = 0; j < oldTs; j++) {
            HashNode<T> temp = oldTable.get(j);

            while (temp != null) {
                String key = temp.key;
                T value = temp.value;
                insert(key, value);
                temp = temp.next;
            }

            //destroy the ith linked list
            if (oldTable.get(j) != null) {
                oldTable.set(j, null);
            }
        }
    }

    public void insert(String key, T value) {
        int index = hashFunction(key);
        //create a node to store key and value
        HashNode<T> node = new HashNode<>(key, value);
        node.next = table.get(index);
        table.set(index, node);
        cs++;

        //create load factor to minimise collision
        float loadFactor = cs / (float) ts;
        if (loadFactor > 0.7) {
            rehash();
        }
    }

    public T search(String key) {
        int index = hashFunction(key);
        HashNode<T> temp = table.get(index);
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public void erase(String key) {
        int index = hashFunction(key);
        HashNode<T> currentNode = table.get(index);
        HashNode<T> prevNode = null;
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (prevNode != null) {
                    prevNode.next = currentNode.next;
                } else {
                    table.set(index, currentNode.next);
                }
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void print() {
        System.out.println();
        for (int k = 0; k < ts; k++) {
            HashNode<T> node = table.get(k);
            System.out.println("Bucket " + k + "->");
            while (node != null) {
                System.out.println("Key: " + node.key + " value:" + node.value);
                node = node.next;
            }
            System.out.println();
        }
    }
}
