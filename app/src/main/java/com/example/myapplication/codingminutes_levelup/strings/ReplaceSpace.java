package com.example.myapplication.codingminutes_levelup.strings;

public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("hi hello world!");
        replaceSpace(str);
        System.out.println("Result:"+str);
    }

    static void replaceSpace(StringBuilder str) {
        int spaces = 0;
        //1.calculate spaces
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaces+=1;
            }
        }
        int idx = str.length() + 2 * spaces;
        str.ensureCapacity(idx);

        for (int i = str.length()-1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(idx - 1, '0');
                str.setCharAt(idx - 2, '2');
                str.setCharAt(idx - 3, '%');
                idx = idx - 3;
            } else {
                str.setCharAt(idx - 1, str.charAt(i));
                idx--;
            }
        }
    }
}
