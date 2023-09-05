package com.example.myapplication.codingminutes_levelup.trie;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    void insert(String word) {
        TrieNode temp = root;
        for (Character ch : word.toCharArray()) {
            if (temp != null && !temp.map.containsKey(ch)) {
                TrieNode node = new TrieNode(ch);
                temp.map.put(ch, node);
            }
            if (temp != null) {
                temp = temp.map.get(ch);
            }
        }
        temp.isTerminalNode = true;
    }

    void suffixInsert(String word){
        for (int i = 0; i < word.length(); i++) {
            insert(word.substring(i));
        }
    }

    boolean search(String word) {
        TrieNode temp = root;

        for (Character ch : word.toCharArray()) {
            if (temp != null && !temp.map.containsKey(ch)) {
                return false;
            }
            if (temp != null) {
                temp = temp.map.get(ch);
            }
        }

        return temp != null && temp.isTerminalNode;
    }

}
