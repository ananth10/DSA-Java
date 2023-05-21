package com.example.myapplication.datastructures.array.codingminutes.heaps;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class NearbyCars {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        List<Car> carList = createCarList();
        int k = 3;
        nearbyCars(carList, k);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static void nearbyCars(List<Car> list, int k) {
        PriorityQueue<Car> queue = new PriorityQueue<>(Car::compareTo);
        for (int i = 0; i < k; i++) {
            queue.add(list.get(i));
        }
        System.out.println(queue.peek());
        List<Car> nearByCars = new ArrayList<>();
        for (int j = k; j < list.size(); j++) {
            if (list.get(j).dist() < queue.peek().dist()) {
                queue.poll();
                queue.add(list.get(j));
            }
        }

        while (!queue.isEmpty()) {
            nearByCars.add(queue.poll());
        }

        Collections.reverse(nearByCars);
        System.out.println(nearByCars);
    }

    private static List<Car> createCarList() {
        List<Car> list = new ArrayList<>();
        list.add(new Car("C1", 1, 1));
        list.add(new Car("C2", 2, 1));
        list.add(new Car("C3", 3, 2));
        list.add(new Car("C4", 0, 1));
        list.add(new Car("C5", 2, 3));
        return list;
    }

    private static class Car implements Comparable<Car> {
        String id;
        int x;
        int y;

        public Car(String id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int dist() {
            return (x * x) + (y * y);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "id='" + id + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Car car) {
            return Integer.compare(car.dist(), this.dist());
        }
    }
}
