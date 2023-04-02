package com.example.myapplication.datastructures.array.codingminutes.recursion;

import com.google.gson.Gson;

import java.util.ArrayList;

public class BinaryString {


    static ArrayList<String> list;

    public static void main(String[] args) {
        binaryString();
        System.out.println(new Gson().toJson(list));
    }

    static void helper(StringBuilder str, int n, int i) {
        System.out.println("TEST::111::"+ str);
        if (n == i) {
            System.out.println("TEST::444"+i);
            list.add(str.toString());
            return;
        }
        StringBuilder st1 = new StringBuilder(str.toString());
        st1.append('0');
        helper(st1, n, i+1);  //e.g n=2 and i begin from 0 //function 1 halt here and function 2 start here. and function 2 halt here and function 3 start here and function 3 will return
        System.out.println("TEST::222::"+i); //function 2 will resume first
        System.out.println("TEST::777::"+str.toString());
        System.out.println("TEST::222::"+ new Gson().toJson(list));
        if (i > 0 && str.charAt(i - 1) == '0') {
            System.out.println("TEST::666");
            str.append('1');
            helper(str, n, i + 1);
        } else if (i == 0) {
            System.out.println("TEST::333");
            str.append('1');
            helper(str, n, i + 1);
        }
    }

    static void binaryString() {
        list = new ArrayList<String>();
        StringBuilder str = new StringBuilder();
        int n = 2;
        helper(str,n,0);
    }
}
