package com.example.myapplication.codingminutes_levelup.trie;


import java.util.ArrayList;
import java.util.List;

/**
 * Googly Strings!
 * --------------
 * Prateek bhaiya while working at Google often encounters string problems, so this time he is asking for your help to solve this problem. You are given a list of non-empty strings and you have to return a list of all "Googly" strings found in the input list.
 * <p>
 * A string is said to be Googly if it is exactly made up of atleast two instances of other string in the input list of strings.
 * <p>
 * In order for a string to be googly, just containing two instances of other strings isn't sufficient, the string be exactly made up of those strings. For example, in the list ["a", "b", "abc"] the string "abc" isn't googly, even though it contains "a" and "b", but "c" isn't a string in the list.
 * <p>
 * <p>
 * Note that strings can be repeated to form a special string; for example in the list ["a","aaa"], the string "aaa" is a Googly string because it is made up of three repeated instances of "a".
 * <p>
 * Sample Input
 * ["goo", "gle", "google", "le","googly","ly","g",""googoole"]
 * <p>
 * Sample Output
 * ["gle", "google", "googly","googoole"]
 * Explanation
 * <p>
 * gle = "g" + "le"
 * google = "goo" + "g" + "le"
 * googly = "goo" + "g" + "ly"
 * googoole = "goo" + "goo" + "le"
 * All these strings contains atleast 2 instances of other strings in the list.
 */
public class GooglyString {

    public static void main(String[] args) {
        String[] input = {"goo", "gle", "google", "le", "googly", "ly", "g", "googoole"};
        List<String> output = googleString(input);
        System.out.println("Result:"+output);
    }

    private static List<String> googleString(String[] input) {
        Trie trie = new Trie();
        for (String s : input) {
            trie.insert(s);
        }
        List<String> output = new ArrayList<>();
        //for every word in the list of strings
        //check it can be formed using at least 2 words from the trie

        for (String str : input) {
            int count = 0;
            TrieNode temp = trie.root;
            if (isSpecial(trie, temp, str, 0, count)) {
                output.add(str);
            }
        }

        return output;
    }

    private static boolean isSpecial(Trie trie, TrieNode root, String str, int i, int count) {

        //base case
        if (i == str.length()) {
            System.out.println("Count is " + count + " and " + root.data);
            return root.isTerminalNode && (count + 1) >= 2;
        }
        //recursive case
        char ch = str.charAt(i);
        if (!root.map.containsKey(ch)) {
            return false;
        }
        root = root.map.get(ch);
        if (root != null && root.isTerminalNode) {
            boolean remaining = isSpecial(trie, trie.root, str, i + 1, count + 1);
            if (remaining) {
                return true;
            }
        }
        return isSpecial(trie, root, str, i + 1, count);
    }

}
