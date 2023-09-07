package com.example.myapplication.codingminutes_levelup.trie.max_xor;

/**
 * Biggest XOR
 * ------------
 * Given an array find the maximum XOR that you can form by picking two numbers from the array
 * <p>
 * INPUT:
 * input[] arr= {3,10,5,8,2,25}
 * <p>
 * OUTPUT:
 * 28
 */
public class MaxXor {
    public static void main(String[] args) {
        int[] a = {3, 10, 5, 8, 2, 25};
        int n = a.length;
        int maxXOr = maxXOr(a, n);
        System.out.println("RESULT:"+maxXOr);
    }

    private static int maxXOr(int[] a, int n) {
        int max_xor = Integer.MIN_VALUE;
        Trie trie = new Trie();
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            trie.insert(value);
            int current_xor = maxXorHelper(value, trie.root);
            max_xor = Math.max(current_xor, max_xor);
        }
        return max_xor;
    }


    private static int maxXorHelper(int value, TrieNode root) {
        TrieNode temp = root;
        int current_xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (value >> i) & 1;
            if (bit == 0) {
                if (temp.right != null) {
                    temp = temp.right;
                    current_xor += (1 << i);
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.left != null) {
                    temp = temp.left;
                    current_xor += (1 << i);
                } else {
                    temp = temp.right;
                }
            }
        }
        return current_xor;
    }
}
