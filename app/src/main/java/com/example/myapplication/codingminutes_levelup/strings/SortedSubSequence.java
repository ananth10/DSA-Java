package com.example.myapplication.codingminutes_levelup.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedSubSequence {

    public static void main(String[] args) {
        String input = "abcd";
        List<String> list = new ArrayList<>();
        sortedSubSequence(input, "", list);
        Collections.sort(list,new CustomSort());
        System.out.println(list);
    }

    static class CustomSort implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }else{
               return Integer.compare(o1.length(),o2.length());
            }
        }
    }

    static void sortedSubSequence(String in,String out,List<String> list){
        //base case
        if(in.length()==0){
            list.add(out);
            return;
        }

        //recursive case
        char ch = in.charAt(0);
        String reducedIn = in.substring(1);
        sortedSubSequence(reducedIn,out+ch,list);
        sortedSubSequence(reducedIn,out,list);
    }
}
