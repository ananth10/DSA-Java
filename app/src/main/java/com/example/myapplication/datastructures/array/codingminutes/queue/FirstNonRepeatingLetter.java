package com.example.myapplication.datastructures.array.codingminutes.queue;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNonRepeatingLetter {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
        List<Character> input = Arrays.asList('a', 'b', 'c', 'a');
        ArrayList<Character> list = firstNonRepeatingLetter(input);
        ArrayList<Character> list1 = firstNonRepeatChar(input);
        System.out.println(list);
        System.out.println(list1);
    }

    static ArrayList<Character> firstNonRepeatingLetter(List<Character> input) {
        Queue<Character> queue = new LinkedList<Character>();
        ArrayList<Character> list = new ArrayList<>();
        char[] charCount = new char[26];

        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
            charCount[input.get(i) - 'a']++;
            while (!queue.isEmpty()) {
                if (charCount[queue.peek() - 'a'] > 1) {
                    queue.poll();
                } else {
                    break;
                }
            }

            if (queue.isEmpty()) {
                list.add('0');
            } else {
                list.add(queue.peek());
            }
        }
        return list;
    }

    //using hashmap to save character frequency
    @RequiresApi(api = Build.VERSION_CODES.N)
    static ArrayList<Character> firstNonRepeatChar(List<Character> list) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);

            if (map.get(list.get(i)) == 1) {
                queue.add(list.get(i));
            }

            while (!queue.isEmpty()) {
                char top = queue.peek();
                if (map.get(top) == 1) {
                    break;
                } else {
                    queue.remove();
                }
            }

            if (queue.isEmpty()) {
                result.add('0');
            } else {
                result.add(queue.peek());
            }
        }
        return result;
    }
}
