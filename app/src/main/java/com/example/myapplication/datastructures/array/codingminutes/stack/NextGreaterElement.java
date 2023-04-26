package com.example.myapplication.datastructures.array.codingminutes.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] list = {4, 5, 2, 25};
        int[] result = nextLargestNumber(list);
        int[] result1 = nextGreaterElement(list);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }

    //bruteforce approach
    static int[] nextLargestNumber(int[] array) {
        int[] result = new int[array.length];
        int n = array.length;
        int count = 0;
        boolean isLargerElementFound = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]) {
                    result[count++] = array[j];
                    isLargerElementFound = true;
                    break;
                }
            }
            if (isLargerElementFound) {
                isLargerElementFound = false;
            } else {
                result[count++] = -1;
            }
        }
        return result;
    }

    //using stack

    static int[] nextGreaterElement(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= array[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(array[i]);
        }

        return result;
    }
}
