package com.example.myapplication.datastructures.array.codingminutes.trie;

import java.util.HashMap;

public class TrieNode {
    char data;
    HashMap<Character, TrieNode> map;
    boolean isTerminal;

    public TrieNode(char data) {
        this.data = data;
        map = new HashMap<>();
        isTerminal = false;
    }
}
