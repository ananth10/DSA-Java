package com.example.myapplication.datastructures.array.codingminutes.vector;

public class Vector<T> {
    T[] arr;
    int cs;
    int ms;

    public Vector(int capacity) {
        cs = 0;
        ms = capacity;
        arr = (T[]) new Object[ms];
    }

    void pushBack(T data) {
        if (cs == ms) {
            T[] oldArr = arr;
            ms = 2 * ms;
            arr = (T[]) new Object[ms];

            //copy elements
            for (int i = 0; i < cs; i++) {
                arr[i] = oldArr[i];
            }
        }
        arr[cs] = data;
        cs++;
    }

    void popBack() {
        if (cs > 0) {
            cs--;
        }
    }

    boolean isEmpty() {
        return cs == 0;
    }

    T front() {
        return arr[0];
    }

    T back() {
        return arr[cs - 1];
    }

    T at(int pos) {
        return arr[pos];
    }

    int size() {
        return cs;
    }

    int capacity() {
        return ms;
    }

    T get(int pos) {
        return arr[pos];
    }

}
