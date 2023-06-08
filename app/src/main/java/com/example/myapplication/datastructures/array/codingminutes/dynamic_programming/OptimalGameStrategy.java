package com.example.myapplication.datastructures.array.codingminutes.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;

public class OptimalGameStrategy {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 4};
        int n = arr.length;
        HashMap<ArrayList<Integer>, Integer> map = new HashMap();
        int result = game(n, arr, 0, n - 1, map);
        int result1 = game1(n, arr, 0, n - 1);
        System.out.println("RES:" + result);
        System.out.println("RES:" + result1);
    }

    static int game(int n, int[] v, int s, int e, HashMap<ArrayList<Integer>, Integer> map) {
        //base case
        if ((s > e) || (s >= n) || (e < 0)) {
            return 0;
        }

        ArrayList<Integer> k = new ArrayList<>();
        k.add(s);
        k.add(e);

        if (map.containsKey(k)) {
            return map.get(k);
        }
        // if the user chooses sth coin, the opponent can
        // choose from s+1th or eth coin. if he chooses
        // s+1th coin, user is left with [s+2,e] range. if
        // opp chooses eth coin, then user is left with
        // [s+1,e-1] range to choose from. Also opponent
        // tries to choose in such a way that the user has
        // minimum value left.

        int option1 = v[s] + Math.min(game(n, v, s + 2, e, map), game(n, v, s + 1, e - 1, map));

        // if user chooses eth coin, opponent can choose sth
        // coin or e-1th coin. if opp chooses ith coin,user
        // can choose in range [s+1,e-1]. if opp chooses
        // e-1th coin, user can choose in range [s,e-2].
        int option2 = v[e] + Math.min(game(n, v, s + 1, e - 1, map), game(n, v, s, e - 2, map));

        map.put(k, Math.max(option1, option2));
        return map.get(k);

    }

  //simple approach
    static int game1(int n, int[] v, int s, int e){
        if(s==e || s==e-1){
            return Math.max(v[s],v[e]);
        }

        int op1 = v[s] + Math.min(game1(n,v,s+2,e),game1(n,v,s+1,e-1));
        int op2 = v[e] + Math.min(game1(n,v,s+1,e-1),game1(n,v,s,e-2));

        return Math.max(op1,op2);
    }

}
