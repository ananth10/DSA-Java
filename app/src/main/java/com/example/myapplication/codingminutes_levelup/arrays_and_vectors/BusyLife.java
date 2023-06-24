package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class BusyLife {

    public static void main(String[] args) {
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(7, 9));
        list.add(new Pair(0, 10));
        list.add(new Pair(4, 5));
        list.add(new Pair(8, 9));
        list.add(new Pair(4, 10));
        list.add(new Pair(5, 7));

        int result = busyLife(list);
        System.out.println("Result: " + result);
    }


    static int busyLife(List<Pair> list) {
        Collections.sort(list, Comparator.comparing(pair -> pair.second));
        int count = 1;
        int finishTime = list.get(0).second;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).first >= finishTime) {
                count++;
                finishTime = list.get(i).second;
            }
        }
        return count;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
