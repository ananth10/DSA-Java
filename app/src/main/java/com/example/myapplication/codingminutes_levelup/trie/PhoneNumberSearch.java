package com.example.myapplication.codingminutes_levelup.trie;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Phone Numbers Search
 * --------------------
 * You are given a Android Phone smart keypad which looks exactly like the one shown below.
 * No, its not the regular phone keypad problem!
 * <p>
 * ----- ----- -----
 * |     |     |     |
 * |  1  |  2  |  3  |
 * |     | abc | def |
 * ----- ----- -----
 * |     |     |     |
 * |  4  |  5  |  6  |
 * | ghi | jkl | mno |
 * ----- ----- -----
 * |     |     |     |
 * |  7  |  8  |  9  |
 * | pqrs| tuv | wxyz|
 * ----- ----- -----
 * |     |
 * |  0  |
 * |     |
 * -----
 * As we can see every digit is associated with some letters, for example 2 is mapped with (a,b,c).
 * This allows certain phone numbers to be mapped with actual words
 * For example - the phone number 666 can be written as mom  or moo.
 * Similarly, 7728335  can be written as prateek or something other string as well.
 * Hence, a given phone number can represent multiple possible strings.
 * <p>
 * You are given a phone number (as a string input) and a non-empty list of words.
 * Write a function that returns the list of words that can be found in the phone number.
 * The final list can contain words in any order.
 * (Yes, we will use sorting at the backend to compare your result with ours😉)
 * <p>
 * Sample Input
 * phoneNumber = "7728335"
 * words = {"prat","prateek","codingminutes","code","prat335", "teek"};
 * <p>
 * Sample Output
 * ["prat", "prateek", "teek"]
 * <p>
 * Hint
 * Try to optimise this problem using Trie Data Structure + Unordered Set.
 */
public class PhoneNumberSearch {
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String phone = "7728335";
        String[] input = {"prat", "prateek", "codingminutes", "code", "prat335", "teek"};
        List<String> output = phoneNumberSearch(phone, input);
        System.out.println("Result:"+ output);
    }

    private static class TrieNode {
        char ch;
        boolean isTerminal;
        String s;
        Map<Character, TrieNode> map;

        public TrieNode(char ch) {
            this.ch = ch;
            map = new HashMap<>();
            s = "";
        }
    }

    private static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode('\0');
        }

        void insert(String word) {
            TrieNode temp = root;
            for (Character ch : word.toCharArray()) {
                if (temp != null && !temp.map.containsKey(ch)) {
                    temp.map.put(ch, new TrieNode(ch));
                }
                if (temp != null) {
                    temp = temp.map.get(ch);
                }
            }
            if (temp != null) {
                temp.isTerminal = true;
                temp.s = word;
            }

        }
    }

    private static List<String> phoneNumberSearch(String phone, String[] input) {
        List<String> list = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : input) {
            trie.insert(word);
        }
        Set<String> validWords = new HashSet<>();
        for (int i = 0; i < phone.length(); i++) {
            validWords(trie.root, phone, i, validWords);
        }

        for (String s : validWords) {
            list.add(s);
        }

        return list;
    }

    static void validWords(TrieNode root, String ph, int i, Set<String> set) {
        //base case
        if (root.isTerminal) {
            set.add(root.s);
        }
        if(i==ph.length()){
            return;
        }
        //recursive case
        int digit = ph.charAt(i) - '0';

        //explore the option from current node
        for (int j = 0; j < keypad[digit].length(); j++) {
            char ch = keypad[digit].charAt(j);
            if (root.map.containsKey(ch)) {
                root = root.map.get(ch);
                validWords(root, ph, i + 1, set);
            }
        }
    }

}
