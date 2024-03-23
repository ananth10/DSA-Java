package com.example.myapplication.dynamic_programming.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import kotlin.Pair;

public class Matching {

    static int[][] a = {{0, 1, 1}, {1, 0, 1}, {1, 1, 1}};

    static int n = a.length;
    static Set<Integer> women = new HashSet<>();

    static HashMap<Pair<Integer, Set<Integer>>, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            women.add(i);
        }

        int result = match(0, women);
        System.out.println("result:" + result);

        int result1 = matchUsingMask(0, (1 << n) - 1);
        System.out.println("result1:" + result1);
        System.out.println("result1:" + result1);
    }

    private static int match(int men, Set<Integer> women) {
        //base case
        if (men == n)
            return 1;
        if (map.containsKey(new Pair<>(men, women)) && map.get(new Pair<>(men, women)) != null) {
            return map.get(new Pair<>(men, women));
        }
        int ans = 0;
        for (int x = 0; x < n; x++) {
            if (women.contains(x) && a[men][x] == 1) {
                women.remove(x);
                ans += match(men + 1, women);
                women.add(x);
            }
        }
        map.put(new Pair<>(men, women), ans);
        return ans;
    }

    //bitmask approach

    private static int matchUsingMask(int men, int bitmask) {
        if (men == n)
            return 1;
        int ans = 0;
        for (int x = 0; x < n; x++) {
            int set = (bitmask >> x) & 1;
            int compatible = a[men][x];
            if (set == 1 && compatible == 1) {
                int unset = bitmask ^ (1 << x);
                ans += matchUsingMask(men + 1, unset);
            }
        }
        return ans;
    }
}
