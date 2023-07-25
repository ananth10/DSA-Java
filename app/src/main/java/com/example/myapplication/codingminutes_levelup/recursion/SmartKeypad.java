package com.example.myapplication.codingminutes_levelup.recursion;

/**
 * Smart Keypad
 * ------------
 * <p>
 * Given a number N and a modern phone keypad, find out all possible strings generated using that number.
 * <p>
 * Input :
 * keypad[] = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"}
 * 23
 * <p>
 * output:
 * AD,AE,AF,BD,BE,BF,CD,CE,CF
 */
public class SmartKeypad {
    public static String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        String input = "23";
        String output = "";
        smartKeypad(input, output, 0);
    }

    private static void smartKeypad(String input, String output, int i) {

        //base case
        if (input.isEmpty()) {
            System.out.print(output + ", ");
            return;
        }

        //special case
        int current_digit = input.charAt(0) - '0';
        input = input.substring(1);
        if (current_digit == 0 || current_digit == 1) {
            smartKeypad(input, output, i + 1);
        }
        for (int j = 0; j < keypad[current_digit].length(); j++) {
            smartKeypad(input, output + keypad[current_digit].charAt(j), i + 1);
        }

        return;
    }
}
