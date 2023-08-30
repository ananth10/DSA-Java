package com.example.myapplication.codingminutes_levelup.Hashing;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import kotlin.Pair;

/**
 * Count Rectangle
 * ---------------
 * Given N cartesian points in a 2D plane, find the number of axis parallel
 * rectangle that can be formed.
 * INPUT:
 * N = 8;
 * points = [{0,0},{0,1},{1,1},{1,0},{2,1},{2,0},{3,1},{3,0}]
 * <p>
 * OUTPUT:
 * 6
 */
public class CountRectangle {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(0, 0));
        list.add(new Point(0, 1));
        list.add(new Point(1, 1));
        list.add(new Point(1, 0));
        list.add(new Point(2, 1));
        list.add(new Point(2, 0));
        list.add(new Point(3, 1));
        list.add(new Point(3, 0));

        int count = countRectangle(list);
        System.out.println("Result: " + count);
    }
    @SuppressLint("NewApi")
    private static int countRectangle(List<Point> list) {
        int answer = 0;
        HashMap<Integer, Integer> xFreq = new HashMap<>();
        HashMap<Integer, Integer> yFreq = new HashMap<>();

        for (Point p : list) {
            int x = p.x;
            int y = p.y;
            if (xFreq.containsKey(x)) {
                xFreq.put(x, xFreq.get(x) + 1);
            } else {
                xFreq.put(x, 1);
            }

            if (yFreq.containsKey(y)) {
                yFreq.put(y, yFreq.get(y) + 1);
            } else {
                yFreq.put(y, 1);
            }
        }

        for (Point point :list){
            int x = point.x;
            int y = point.y;

            int xFrequency = xFreq.getOrDefault(x,0);
            int yFrequency = yFreq.getOrDefault(y,0);

            answer+=(xFrequency-1)*(yFrequency-1);

        }

        return answer;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
