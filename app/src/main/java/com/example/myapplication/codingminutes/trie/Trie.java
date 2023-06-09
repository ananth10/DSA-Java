package com.example.myapplication.codingminutes.trie;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    //Insertion
    void insert(String word) {
        TrieNode temp = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.map.containsKey(ch)) {
                TrieNode node = new TrieNode(ch);
                temp.map.put(ch, node);
            }
            temp = temp.map.get(ch);
        }
        temp.isTerminal = true;
    }

    //Searching
    boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!temp.map.containsKey(ch)) {
                return false;
            }
            temp = temp.map.get(ch);
        }

        return temp.isTerminal;
    }
}
