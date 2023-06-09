package com.example.myapplication.codingminutes.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueSubSet {

    public static void main(String args[]) {
        int[] input = {1, 2, 2};
        int[] output = new int[input.length];
        int i = 0;
        int j = 0;
        ArrayList<String> list = new ArrayList<>();
        findSubSet(input, output, i, j, list);
        Collections.sort(list);
        System.out.println(list);
    }

    static void findSubSet(int[] input, int[] output, int i, int j, ArrayList<String> result) {
        //basecase
        if (i == input.length) {
            String value = Arrays.toString(output);
            if (!result.contains(value)) {
                result.add(value);
            }
            System.out.println(Arrays.toString(output));
            return;
        }

        //recursive case
        output[j] = input[i];
        findSubSet(input, output, i + 1, j + 1, result);
        output[j] = 0;
        findSubSet(input, output, i + 1, j, result);
    }

}


