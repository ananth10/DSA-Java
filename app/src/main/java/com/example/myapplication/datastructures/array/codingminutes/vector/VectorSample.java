package com.example.myapplication.datastructures.array.codingminutes.vector;

import java.util.ArrayList;
import java.util.List;

public class VectorSample {

    public static void main(String[] args) {
//        ar1();

        VectorOperations();
    }

    static void ar1() {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            List<Integer> al1 = new ArrayList<>();
            for (int j = 1; j < 5; j++) {
                al1.add(j);
            }
            list.add(al1);
        }

        System.out.println("LIST SIZE::" + list.size());
        for (int i = 0; i < list.size(); i++) {
            List<Integer> ll = list.get(i);
            for (int j = 0; j < ll.size(); j++) {
                System.out.print(ll.get(j) + " ");
            }
            System.out.println("INNER::" + ll.size());
        }
    }

    static void VectorOperations() {
        Vector<Integer> vector = new Vector<>(2);
        vector.pushBack(1);
        vector.pushBack(2);
        vector.pushBack(3);
        vector.pushBack(4);
        vector.pushBack(5);
        printVector(vector);
        System.out.println("Size:"+vector.size());
        System.out.println("Capacity:"+vector.capacity());

        System.out.println("front:"+vector.front());
        System.out.println("back:"+vector.back());
    }

    private static void printVector(Vector vector) {
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
    }
}
