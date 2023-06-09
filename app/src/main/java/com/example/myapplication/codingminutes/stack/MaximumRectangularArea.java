package com.example.myapplication.codingminutes.stack;

import androidx.core.util.Pair;

import java.util.Stack;

public class MaximumRectangularArea {

    public static void main(String[] args) {
        int[] input = {6, 2, 5, 4, 5, 1, 6};
//        int result = maximumRectangularArea(input);
//        System.out.println("result: "+result);
        int result1 = getMaxArea(input);
        System.out.println("result1: " + result1);
    }

    //brute force approach
    static int maximumRectangularArea(int[] input) {
        int n = input.length;
        int barWidth = 1;
        int totalBars = 0;
        int maxRectArea = 0;

        for (int i = 0; i < n; i++) {
            totalBars = barWidth;
            //check right side value
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[i]) {
                    break;
                }
                totalBars += barWidth;
            }
            //check left side value
            if (i > 0) {
                for (int k = i - 1; k >= 0; k--) {
                    if (input[k] < input[i]) {
                        break;
                    }
                    totalBars += barWidth;
                }
            }
            int totalArea = input[i] * totalBars;
            if (totalArea > maxRectArea) {
                maxRectArea = totalArea;
            }
            System.out.println("MAX:" + maxRectArea);
        }

        return maxRectArea;
    }

    //optimised approach

    static int getMaxArea(int[] array) {
        int maxArea = 0;
        Stack<StackPair> stack = new Stack<>();
        int n = array.length;
        int i = 0;
        int totalArea = 0;


        while (i < n) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().height > array[i]) {
                StackPair top = stack.peek();
                stack.pop();
                totalArea = (i - top.index) * top.height;
                maxArea = Math.max(totalArea, maxArea);
                System.out.println("MAX:" + maxArea);
                start = top.index;
            }
            StackPair pair = new StackPair(start, array[i]);
            stack.push(pair);
            System.out.println("I:" + i + "stack :" + stack);
            i++;
        }

        System.out.println(stack);
        while (!stack.isEmpty()) {
            StackPair top = stack.peek();
            stack.pop();
            totalArea = (n - top.index) * top.height;
            maxArea = Math.max(totalArea, maxArea);
        }

        return maxArea;
    }
}

class StackPair {
    int index;
    int height;

    public StackPair(int index, int height) {
        this.index = index;
        this.height = height;
    }

    @Override
    public String toString() {
        return "StackPair{" +
                "index=" + index +
                ", height=" + height +
                '}';
    }
}
