package com.example.myapplication.codingminutes.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class PrefixString {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "abd", "acde", "abe", "aeb", "abba");
        String small = "ab";
        List<String> result = prefixString(words, small);
        System.out.println("RESULT::" + result);
    }

    static List<String> prefixString(List<String> words, String small) {
        Trie trie = new Trie();
        ArrayList<String> result = new ArrayList<>();
        TrieNode root = trie.root;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            trie.insert(words.get(i));
        }

        for (int j = 0; j < small.length(); j++) {

            if (!root.map.containsKey(small.charAt(j))) {
                return result;
            }

            word.append(small.charAt(j));
            root = root.map.get(small.charAt(j));
        }

        dfs(root, result, word);
        Collections.sort(result);
        return result;
    }

    static void dfs(TrieNode temp, List<String> result, StringBuilder word) {
        //base case
        if (temp.isTerminal) {
            result.add(word.toString());
        }
        if (temp.map.isEmpty()) {
            return;
        }

        //recursive case
        for (Map.Entry<Character, TrieNode> pair : temp.map.entrySet()) {
            word.append(pair.getKey());
            dfs(temp.map.get(pair.getKey()), result, word);
            word.deleteCharAt(word.length() - 1);
        }

        return;
    }
}
