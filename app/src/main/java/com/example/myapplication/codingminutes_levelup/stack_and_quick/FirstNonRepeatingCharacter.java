package com.example.myapplication.codingminutes_levelup.stack_and_quick;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * First Non-Repeating Character
 * ----------------------------
 * Given a stream of characters (lowercase alphabets),
 * find the first non-repeating character from stream.
 * You need to tell the first non-repeating character in O(1) time at each index.
 * If for a current index there is no such character return '0' for that particular index.
 *
 * Input:
 *
 * aabcbcd
 *
 * Output:
 *
 * a 0 b b c 0 d
 *
 * Explanation:
 *
 * At index 0, 'a' is the only character we have and hence non repeating.
 *
 * At index 1, we have 2 characters till now and they are same, hence no non-repeating character.
 *
 * At index 2, 'b' is the only non repeating character till now.
 *
 * At index 3, 'b' and 'c' are non repeating characters, but 'b' is the FIRST non repeating character till now.
 *
 * At index 4, 'c' is the only non repeating character till now.
 *
 * At index 5, there is no non repeating character till now.
 *
 * At index 6, 'd' is the only and first non repeating character.
 * */
@RequiresApi(api = Build.VERSION_CODES.N)
public class FirstNonRepeatingCharacter {

    public static void main(String[] args){
        String input = "aabccbcd";
        List<Character> result = firstNonRepeatingCharacter(input);
        System.out.println("Result:"+ result);
    }


    private static List<Character> firstNonRepeatingCharacter(String input) {
        Queue<Character> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>(); //we can also user array int[27] = {0};
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            queue.add(ch);
            while (!queue.isEmpty()){
                char top = queue.peek();
                if(map.get(top)>1){
                    queue.remove();
                }else {
                    list.add(top);
                    break;
                }
            }
            if(queue.isEmpty()){
                list.add('0');
            }
        }

        return list;
    }
}
