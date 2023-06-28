package com.example.myapplication.codingminutes_levelup.strings;

public class DigitalClock {

    public static void main(String[] args){
        int input = 1180;
        String result = digitalClock(input);
        System.out.println(result);
    }

    static String digitalClock(int input){
        int hours = input/60;
        int minutes = input%60;
        String hr = String.valueOf(hours);
        String mins = String.valueOf(minutes);

        return hr+":"+mins;
    }
}
