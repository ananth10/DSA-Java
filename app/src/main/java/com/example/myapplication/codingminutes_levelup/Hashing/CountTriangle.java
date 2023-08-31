package com.example.myapplication.codingminutes_levelup.Hashing;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Count Rectangle
 * ---------------
 * Given N cartesian points in a 2D plane, find the number of triangle such that
 * the base or perpendicular is parallel to the X or Y axis.
 *
 * INPUT:
 * N = 5;
 * points = [{1,2},{2,0},{2,2},{2,3},{4,2}]
 * <p>
 * OUTPUT:
 * 6
 */
public class CountTriangle {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(2,0));
        list.add(new Point(2,2));
        list.add(new Point(2,3));
        list.add(new Point(4,2));

        int count = countTriangle(list);
        System.out.println("Result: " + count);
    }
    @SuppressLint("NewApi")
    private static int countTriangle(List<Point> list) {
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
