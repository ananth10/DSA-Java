package com.example.myapplication.codingminutes.backtracking;

public class WordSearch {

    public static void main(String[] arg) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean result = wordSearch(board, word);
        System.out.println(result);
    }

    static boolean wordSearch(char[][] board, String word) {
        //search the first word

        for (int k = 0; k < board.length; k++) {
            for (int m = 0; m < board[k].length; m++) {
                if (board[k][m] == word.charAt(0) && Dfs(board, k, m, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean Dfs(char[][] board, int i, int j, int wordPos, String word) {
        //basecase
        if (wordPos == word.length()) {
            return true;
        }

        //recursive case
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(wordPos)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '~';

        boolean found = Dfs(board, i - 1, j, wordPos + 1, word) ||
                Dfs(board, i + 1, j, wordPos + 1, word) ||
                Dfs(board, i, j - 1, wordPos + 1, word) ||
                Dfs(board, i, j + 1, wordPos + 1, word);
        board[i][j] = temp;
        return found;
    }
}
