package com.example.myapplication.codingminutes.vector;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingCabs {

    public static void main(String[] args){
        sortCabs();
    }

    static void sortCabs(){
        ArrayList<Cabs> cabsArrayList= new ArrayList(Arrays.asList(new Cabs(2,3), new Cabs(1,2),new Cabs(3,4),new Cabs(2,4), new Cabs(1,4)));

        Collections.sort(cabsArrayList);

        for(int i=0;i<cabsArrayList.size();i++){
            System.out.println(new Gson().toJson(cabsArrayList.get(i)));
        }
    }

    static class Cabs implements Comparable<Cabs>{
        int x;
        int y;

        public Cabs(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cabs o) {
            return calculateDistance(this.x,this.y)-calculateDistance(o.x,o.y);
        }

        int calculateDistance(int x,int y){
            return x+y;
        }
    }
}
