package com.example.myapplication.codingminutes.vector;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingFruit {

    public static void main(String[] args) {
        sortFruit();
    }


    static void sortFruit() {
        ArrayList<Fruit> fruitArrayList = new ArrayList(Arrays.asList(new Fruit("Mango", 100), new Fruit("Guava", 70), new Fruit("Grapes", 40), new Fruit("Apple", 60), new Fruit("Banana", 30)));
        Collections.sort(fruitArrayList);


        for (int i = 0; i < fruitArrayList.size(); i++) {
            System.out.println(new Gson().toJson(fruitArrayList.get(i)));
        }
    }

}

class Fruit implements Comparable<Fruit> {
    String name;
    int price;
    String type = "price";

    public void setType(String type){
        this.type = type;
    }
    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Fruit o) {
        if (type.equals("price")) {
            return this.price - o.price;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}

