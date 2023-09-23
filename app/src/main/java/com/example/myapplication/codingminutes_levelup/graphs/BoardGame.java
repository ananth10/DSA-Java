package com.example.myapplication.codingminutes_levelup.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class BoardGame {
    static int m = 3;
    static int n = 4;

    public static void main(String[] args) {
        String[] words = {"SNAKE", "FOR", "QUEZ", "SNACK", "SNACKS", "GO", "TUNES", "CAT"};
        char[][] board = {
                {'S', 'E', 'R', 'T'},
                {'U', 'N', 'K', 'S'},
                {'T', 'C', 'A', 'T'}
        };
        boardGame(words, board, m, n);
    }

    static class TrieNode {
        char ch;
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isTerminal;
        String word;

        public TrieNode(char ch) {
            this.ch = ch;
            isTerminal = false;
            word = "";
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "ch=" + ch +
                    ", map=" + map +
                    ", isTerminal=" + isTerminal +
                    ", word='" + word + '\'' +
                    '}';
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }

        void addWord(String word) {
            TrieNode temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.map.containsKey(ch)) {
                    temp.map.put(ch, new TrieNode(ch));
                }
                temp = temp.map.get(ch);
            }
            temp.isTerminal = true;
            temp.word = word;
        }
    }

    static void boardGame(String[] words, char[][] board, int m, int n) {
        //1. insert all words into trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        //2. create a visited array to save already visited cell in the board and set to save the result
        boolean[][] visited = new boolean[m][n];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        Set<String> result = new HashSet<>();
        //3. iterate over given board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, trie.root, i, j, result, visited);
            }
        }
        //4 . print the result
        Iterator<String> it = result.iterator();
        while (it.hasNext()) {
            String word = it.next();
            System.out.println(word);
        }

    }

    static void dfs(char[][] board, TrieNode node, int i, int j, Set<String> result, boolean[][] visited) {
        Character ch = board[i][j];
        //base case
        if (!node.map.containsKey(ch)) {
            return;
        }

        //recursive case
        visited[i][j] = true;
        TrieNode trieNode = node.map.get(ch);
        if (trieNode.isTerminal) {
            result.add(trieNode.word);
        }

        //8-way direction positions array
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        //iterate over 8 ways and do dfs
        for (int k = 0; k < 8; k++) {
            int di = i + dx[k];
            int dj = j + dy[k];
            //if its in bounds and visited
            if (di >= 0 && dj >= 0 && di < m && dj < n && !visited[di][dj]) {
                dfs(board, trieNode, di, dj, result, visited);
            }
        }
        visited[i][j] = false;

    }
}
