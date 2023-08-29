package com.example.myapplication.codingminutes_levelup.Hashing;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Common Elements
 * ---------------
 * Given two vectors, your task is to find the common elements between them.
 * All elements in one vector are unique among themselves.
 * Input Format:
 * Function contains two integer vectors v1 and v2 as parameters
 * Output Format:
 * Return a vector containing list of common elements in sorted order.
 * <p>
 * Constraints:
 * 1 <= v1.size() <= 10^6
 * 1 <= v2.size() <= 10^6
 * 1 <= v1[i],v2[i] <= 10^6
 * Sample Testcase:
 * Input:
 * v1[] = {1, 45, 54, 71, 76, 12},
 * v2[] = {1, 7, 5, 4, 6, 12}
 * <p>
 * Output:
 * {1, 12}
 */
public class CommonElements {

    public static void main(String[] args) {
        int[] v1 = {1, 45, 54, 71, 76, 12};
        int[] v2 = {1, 7, 5, 4, 6, 12};

        List<Integer> result = commonElements(v1, v2);
        System.out.println("Common Elements:" + result);
    }

    @SuppressLint("NewApi")
    private static List<Integer> commonElements(int[] v1, int[] v2) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        Arrays.sort(v1);
        Arrays.sort(v2);
        for (int x:v1){
            map.put(x,true);
        }
        for(int y:v2){
            if(map.get(y)!=null && map.get(y)){
                list.add(y);
            }
        }
        return list;
    }
}
