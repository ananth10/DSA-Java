package com.example.myapplication.codingminutes_levelup.sliding_window;

import java.util.Arrays;

public class SmallestDistinctWindow {

    public static void main(String[] args) {
        String str = "aabcbcdbcaaad";
        String result = smallestDistinctWindow(str);
        System.out.println("Result: " + result);
    }

    static String smallestDistinctWindow(String str) {
        int n = str.length();
        if (n == 0)
            return "";

        boolean[] visited = new boolean[256];
        Arrays.fill(visited, false);

        int dis_count = 0;
        int min_window_length = Integer.MAX_VALUE;

        //find distinct character count
        for (int i = 0; i < n; i++) {
            if (!visited[str.charAt(i)]) {
                visited[str.charAt(i)] = true;
                dis_count++;
            }
        }

        //maintain the window of character that contains all the character of given string.
        int[] curr_count = new int[256];
        int count = 0;
        int start = 0;
        int start_ids = -1;
        int len_window = 0;
        for (int i = 0; i < n; i++) {
            curr_count[str.charAt(i)]++;

            //if any distinct character matched increase the count
            if (curr_count[str.charAt(i)] == 1) {
                count++;
            }

            if (count == dis_count) {
                //try to minimize the window,that is if any character occurs more number of time than its occurrence in the pattern
                //if yes then remove it from starting and also remove useless character

                while (curr_count[str.charAt(start)] > 1) {
                    if (curr_count[str.charAt(start)] > 1)
                        curr_count[str.charAt(start)]--;
                    start++;
                }
                len_window = i - start + 1;
                if (len_window < min_window_length) {
                    min_window_length = len_window;
                    start_ids = start;
                }
            }
        }

        return str.substring(start_ids, start_ids + min_window_length);
    }
}
