package com.example.myapplication.codingminutes.graph;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KeysAndRooms {

    //[[1,3],[3,0,1],[2],[0]]
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Collections.singletonList(2), Collections.singletonList(0)

        );
        boolean isAllRoomsVisited = canVisitAllRooms(rooms);
        System.out.println("Is All Room Visited:" + isAllRoomsVisited);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, false);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); //Room 0 is opened, so put that into our queue

        while (!queue.isEmpty()) {
            int k = queue.size();
            while (k-- != 0) {
                int a = queue.peek();
                queue.poll();
                map.put(a, true);
                for (int i = 0; i < rooms.get(a).size() && rooms.get(a).size() != 0; i++) {
                    if (!map.getOrDefault(rooms.get(a).get(i), false)) {
                        queue.add(rooms.get(a).get(i));
                    }
                }
            }
        }

        for (Map.Entry<Integer, Boolean> pair : map.entrySet()) {
            if (!pair.getValue()) {
                return false;
            }
        }
        return true;
    }
}
