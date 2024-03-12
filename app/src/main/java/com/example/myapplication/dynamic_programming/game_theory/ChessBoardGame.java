package com.example.myapplication.dynamic_programming.game_theory;

import java.util.HashMap;

import kotlin.Pair;

public class ChessBoardGame {
    public static void main(String[] args) {
        int x = 5;
        int y = 2;
        HashMap<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
        boolean result = giveState(x, y, map);
        if (result) {
            System.out.println("Result: First");
        } else {
            System.out.println("Result: Second");
        }
    }

    static boolean giveState(int x, int y, HashMap<Pair<Integer, Integer>, Boolean> map) {

        if (x < 1 || x > 15 || y < 1 || y > 15)
            return true;

        if (Boolean.TRUE.equals(map.get(new Pair<>(x, y)))) {
            return Boolean.TRUE.equals(map.get(new Pair<>(x, y)));
        }
        boolean ans = true;
        ans &= giveState(x - 2, y + 1, map);
        ans &= giveState(x - 2, y - 1, map);
        ans &= giveState(x + 1, y - 2, map);
        ans &= giveState(x - 1, y - 2, map);
        ans = !ans;
        map.put(new Pair<>(x, y), ans);
        return ans;
    }
}
