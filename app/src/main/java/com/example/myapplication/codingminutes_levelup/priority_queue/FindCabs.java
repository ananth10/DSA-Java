package com.example.myapplication.codingminutes_levelup.priority_queue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import kotlin.Pair;

/**
 * Finding Cabs
 * -------------
 * Given N cartesian points in  a 2D plane each represented the location of the
 * cab, you are standing at origin, you want to know the names of nearest K cars
 * <p>
 * INPUT:
 * N=5, K=3
 * C1 = 1,1
 * C2 = 2,1
 * C3 = 3,2
 * C4 = 0,1
 * C5 = 2,3
 * <p>
 * OUTPUT:
 * C4
 * C1
 * C2
 */
public class FindCabs {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        Point c1 = new Point("C1", 1, 1);
        Point c2 = new Point("C2", 2, 1);
        Point c3 = new Point("C3", 3, 2);
        Point c4 = new Point("C4", 0, 1);
        Point c5 = new Point("C5", 2, 3);
        List<Point> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);

        int k = 3;
        System.out.println("Near by cars:" + findNearByCabs(list, k));

    }

    private static class Point implements Comparable<Point> {
        String id;
        int x;
        int y;

        public Point(String id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int distance() {
            return (x * x) + (y * y);
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(o.distance(), this.distance());
        }

        @Override
        public String toString() {
            return "Point{" +
                    "id='" + id + '\'' +
                    '}';
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    static List<Point> findNearByCabs(List<Point> list, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Point::compareTo);
        int i;
        //put first k number of cars
        for (i = 0; i < k; i++) {
            pq.add(list.get(i));
        }

        List<Point> nearByCarsList = new ArrayList<>();
        for (; i < list.size(); i++) {
            int dist = list.get(i).distance();
            if (dist < pq.peek().distance()) {
                pq.poll();
                pq.add(list.get(i));
            }
        }

        while (!pq.isEmpty()) {
            nearByCarsList.add(pq.poll());
        }
        Collections.reverse(nearByCarsList);
        return nearByCarsList;
    }
}
