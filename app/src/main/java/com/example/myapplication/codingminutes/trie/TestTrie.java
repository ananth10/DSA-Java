package com.example.myapplication.codingminutes.trie;

public class TestTrie {

    public static void main(String[] args){
        String[] words = {"hello","he","apple","aple","news"};
        Trie trie = new Trie();
        for (String word:words){
           trie.insert(word);
        }

        String key ="apple";
        System.out.println("is Key Present:"+trie.search(key));
    }
}
