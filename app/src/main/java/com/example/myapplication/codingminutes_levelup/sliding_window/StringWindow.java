package com.example.myapplication.codingminutes_levelup.sliding_window;

import java.util.Arrays;

public class StringWindow {


    public static void main(String[] args) {
        String s1 = "fizzbuzz";
        String s2 = "fuzz";

        String result = stringWindow(s1, s2);

        System.out.println("Result : " + result);
    }

    static String stringWindow(String s1, String s2) {
        int[] FP = new int[256];
        Arrays.fill(FP, 0);

        int[] FS = new int[256];
        Arrays.fill(FS, 0);

        //put 2nd string's char count inside the frequency pattern(FP)
        for (int i = 0; i < s2.length(); i++) {
            Character ch = s2.charAt(i);
            FS[ch]++;
        }

        //Sliding window algorithm
        int count = 0;
        int start = 0; //starting point of the window.
        int start_idx = -1;
        int min_so_far = Integer.MAX_VALUE;
        int window_size;
        for (int i = 0; i < s1.length(); i++) {
            //expand the window by including the current char
            Character ch = s1.charAt(i);
            FS[ch]++;

            //Count how many characters have been matched till now (matching between s1,s2)
            if (FP[ch] != 0 && FS[ch] <= FP[ch]) {
                count+=1;
            }

            //if all characters of the pattern are found in the current window then  you can start contracting
            if (count == s2.length()) {
                //start contracting from the left to remove unwanted character.(either not present in the s2 or its frequency higher than required.
                Character ch1 = s1.charAt(start);
                while (FP[ch] == 0 || FS[ch1] > FP[ch1]) {
                    FS[s1.charAt(start)]--;
                    start++;
                }

                //note the window size
                window_size = i-start+1;
                if(window_size<min_so_far){
                    min_so_far = window_size;
                    start_idx = start;
                }
            }
        }

        if(start_idx==-1){
            return "No Window found";

        }
        return s1.substring(start);
    }
}
