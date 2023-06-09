package com.example.myapplication.codingminutes.hashtable;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ArrayIntersection {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        int[] array1 = {1, 2, 2, 1};
        int[] array2 = {2, 2};
        List<Integer> result = intersectNumbers(array1, array2);
        System.out.println("RESULT:" + result);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static ArrayList<Integer> intersectNumbers(int[] array1, int[] array2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array1.length; i++) {
            map.put(array1[i], map.getOrDefault(array1[i], 0) + 1);
        }

        for (int j = 0; j < array2.length; j++) {
            if (map.getOrDefault(array2[j],0) != 0) {
                result.add(array2[j]);
                map.put(array2[j],0);
            }
        }
        Collections.sort(result);
        return result;
    }
}
