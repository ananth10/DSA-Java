package com.example.myapplication.codingminutes.stack;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];
//        stockSpan(prices, n, span);
        stockSpannerUsingStack(prices, n, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + ",");
        }
    }

    //using the bruteforce approach
    static void stockSpan(int[] prices, int n, int[] span) {
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            span[i] = 1;
            for (int j = i - 1; j >= 0 && (prices[i] >= prices[j]); j--) {
                span[i]++;
            }
        }
    }

    //using stack
    static void stockSpannerUsingStack(int[] prices, int n, int[] span) {
        //create a stack to store index of price array
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        span[0] = 1;

        for (int i = 1; i<=n-1; i++) {
            int currentPrice = prices[i];

            while (!stack.empty() && prices[stack.peek()] <= currentPrice) {
                stack.pop();
            }

            if (stack.empty()) {
                span[i] = i + 1;
            } else {
                int previousHighest = stack.peek();
                span[i] = i-previousHighest;
            }

            stack.push(i);
        }
    }
}
