package com.example.myapplication.codingminutes.recursion;

import com.google.gson.Gson;


import java.util.ArrayList;

public class findAllOccurrence {

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 3, 1, 2, 3, 8, 6, 3, 6, 7, 9};
        int i = 0;
        int n = arr.length;
        int key = 3;
        ArrayList<Integer> indicesList = new ArrayList<>();
        System.out.println("result::"+new Gson().toJson(findAllOccurrences(arr, i, n, key, indicesList)));
    }

    static ArrayList<Integer> findAllOccurrences(int arr[], int i, int n, int key, ArrayList<Integer> indicesList) {
        //base case
        if (n == 0 || i==n-1) {
            return indicesList;
        }
        if (arr[i] == key) {
            indicesList.add(i);
        }
        findAllOccurrences(arr, i + 1, n, key, indicesList);
        return indicesList;
    }
}
