package com.example.myapplication.codingminutes_levelup.sorting_searching;

/**
 * Given a sorted array of strings, that is interspersed with empty strings, write
 * a method to find the location of given string.
 */
public class SparseSearch {
    public static void main(String[] args) {
        String[] str = {"ai", "", "", "bat", "", "", "cat", "cat", "", "", "dog", ""};
        String key = "bat";
        int result = sparseString(str, key);
        System.out.println("Result:" + result);
    }

    static int sparseString(String[] str, String key) {
        int s = 0;
        int e = str.length - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int mid_left = mid - 1;
            int mid_right = mid + 1;
            if (str[mid].equals("")) {
                while (true) {
                    if (mid_left < s && mid_right > e) {
                        return -1;
                    } else if (mid_left >= s && !str[mid_left].equals("")) {
                        mid = mid_left;
                        break;
                    } else if (mid_right <= e && !str[mid_right].equals("")) {
                        mid = mid_right;
                        break;
                    }
                    mid_left--;
                    mid_right++;
                }
            }

            if (str[mid].equals(key)) {
                return mid;
            } else if (str[mid].compareTo(key) > 0) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
