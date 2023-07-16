package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.ArrayList;
import java.util.List;

public class InversionCount {

    public static void main(String[] args) {
        int[] a = {0, 5, 2, 3, 1};
        int result = inversion_count(a, 0, a.length - 1);
        System.out.println("Result: " + result);
    }

    static int inversion_count(int[] a, int s, int e) {
        //base case
        if (s >= e) {
            return 0;
        }

        //recursive case
        int mid = (s + e) / 2;
        int c1 = inversion_count(a, s, mid);
        int c2 = inversion_count(a, mid + 1, e);
        int cross = merge(a, s, e);
        return c1 + c2 + cross;
    }

    static int merge(int[] a, int s, int e) {
        int i = s;
        int mid = (s + e) / 2;
        int j = mid + 1;
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while (i <= mid && j <= e) {
            if (a[i] < a[j]) {
                list.add(a[i]);
                i++;
            } else {
                count += (mid - i + 1); //if right array element is less than left array element, then right element must be less than whatever elements come after that left element. e.g left=(0,3,5) right=(1,7) here 1 is less than 3 and 5, so we are count all mid-i+1
                list.add(a[j]);
                j++;
            }
        }

        //if anything left in the left array then add to list
        while (i <= mid) {
            list.add(a[i++]);
        }
        //if anything left in the right array then add to list
        while (j <= e) {
            list.add(a[j++]);
        }

        int k = 0;
        for (int m = s; m <= e; m++) {
            a[m] = list.get(k++);
        }
        return count;
    }

}
