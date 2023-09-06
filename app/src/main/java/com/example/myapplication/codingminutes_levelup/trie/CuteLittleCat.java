package com.example.myapplication.codingminutes_levelup.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Little Cute Cat
 * ---------------
 * Little cute kitten loves to write a stories in a github readme document one day
 * she is given a list of words, you want to help her to check if each of these words are present in the read me file
 * INPUT:
 * Document = "little cute cat loves to code in c++, java & python"
 * words = ["cute cat","ttle","cutest","cat","quick","big"]
 * OUTPUT:
 * yes, yes, no, yes, no, no
 */
public class CuteLittleCat {

    public static void main(String[] args) {
        String document = "little cute cat loves to code in c++, java & python";
        String[] words = {"cute cat", "ttle", "cutest", "cat", "quick", "big"};
        documentSearch(document, words);
    }

    static void documentSearch(String document, String[] words) {
        //insert all words in trie

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        //search document in trie
        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < document.length(); i++) {
            search(trie, document, i, map);
        }
        //search list of word in hashmap
        for (String word : words) {
            if (map.containsKey(word) && Boolean.TRUE.equals(map.get(word))) {
                System.out.print("True,");
            } else {
                System.out.print("False,");
            }
        }
    }

    private static void search(Trie trie, String document, int i, Map<String, Boolean> map) {

        TrieNode temp = trie.root;
        for (int j = i; j < document.length(); j++) {
            Character ch = document.charAt(j);
            if (temp != null && !temp.map.containsKey(ch)) {
                return;
            }
            if (temp != null) {
                temp = temp.map.get(ch);
            }
            if (temp != null && temp.isTerminalNode) {
                String out = subStringUtil(document,i, j - i + 1);
                map.put(out, true);
            }
        }
    }

    private static String subStringUtil(String str, int start_window, int i) {

        int inc = start_window;
        StringBuilder str1 = new StringBuilder();

        while (i != 0) {

            str1.append(str.charAt(inc));
            inc++;
            i--;
        }

        return str1.toString();
    }

}
