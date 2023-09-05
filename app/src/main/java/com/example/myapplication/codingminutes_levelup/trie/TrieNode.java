package com.example.myapplication.codingminutes_levelup.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    char data;
    Map<Character,TrieNode> map;
    boolean isTerminalNode;

    public TrieNode(char data) {
        this.data = data;
        map = new HashMap<>();
        isTerminalNode = false;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "data=" + data +
                ", map=" + map +
                ", isTerminalNode=" + isTerminalNode +
                '}';
    }
}
