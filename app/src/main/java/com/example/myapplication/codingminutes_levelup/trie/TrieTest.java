package com.example.myapplication.codingminutes_levelup.trie;

public class TrieTest {

    public static void main(String[] args) {
        suffixTrieTesT();
    }

    static void trieTest() {
        Trie trie = new Trie();
        String[] words = {"apple", "ape", "no", "news", "not", "never"};
        String[] queries = {"apple", "banana", "new", "mango"};

        for (String word : words) {
            trie.insert(word);
        }
        for (String word : queries) {
            System.out.print(trie.search(word) + ", ");
        }
    }

    static void suffixTrieTesT() {
        String word = "hello";
        Trie trie = new Trie();
        trie.suffixInsert(word);

        String[] queries = {"lo", "ell", "hello"};
        for (String val : queries) {
            System.out.print(trie.search(val) + ", ");
        }
    }
}
