package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class WordBreak {

    public static void main(String[] args) {
        int count = wordBreak();
        System.out.println(count);
    }

    public static int wordBreak() {
        int count = 0;
        String input = "ilikesamsungmobile";
        String[] dictionary = {"i", "like", "sam", "sung","samsung", "mobile"};
        int length = input.length();
        help(input, length, "", dictionary);
        return count;
    }

    public static void help(String str, int n, String result, String[] dict) {
        for (int i = 1; i <= n; i++) {
            String subString = str.substring(0, i);
            int l = dict.length;
            boolean flag = false;
            for (int j = 0; j < l; j++) {
              if(dict[j].equals(subString)){
                  flag = true;
                  break;
              }
            }
            if(flag){
               if(i==n){
                   result+=subString;
                   System.out.println("result::"+result);
                   return;
               }
               help(str.substring(i,n),n-i,result+subString+" ",dict);
            }
            System.out.println("backtrack: "+subString);
        }
    }
}
