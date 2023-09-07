package com.example.myapplication.codingminutes_levelup.trie.max_xor;

public class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(int n) {
        TrieNode temp = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (n>>i)&1;
            if(bit==0){
                if(temp.left==null){
                    temp.left = new TrieNode();
                }
                temp = temp.left;
            }else{
                if(temp.right==null){
                    temp.right = new TrieNode();
                }
                temp = temp.right;
            }
        }
    }

}
