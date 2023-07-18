package com.example.myapplication.codingminutes_levelup.sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kotlin.Pair;


public class IcpcStandings {
    public static void main(String[] args) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair<>("WinOrBooze", 1));
        list.add(new Pair<>("BallOfDuty", 2));
        list.add(new Pair<>("WhoKnows", 2));
        list.add(new Pair<>("BholeChature", 1));
        list.add(new Pair<>("DCECoders", 5));
        list.add(new Pair<>("StrangeCase", 7));
        list.add(new Pair<>("WhoKnows", 7));

        int result = icpcStandings(list);
        System.out.println("Result:" + result);

    }

    static int icpcStandings(List<Pair<String, Integer>> list) {
        int n = list.size();
        int[] count = new int[n + 1];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[list.get(i).getSecond()]++;
        }

        int pos = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            while (count[i] != 0) {
                sum += Math.abs(pos - i);
                count[i]--;
                pos++;
            }
        }
        return sum;
    }
}
