package com.example.myapplication.codingminutes_levelup.stack_and_quick;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import kotlin.Pair;

/**
 * Stock Span Problem
 * -------------------
 * You are given price of a stock over next n days, your task is to calculate span of stock’s price for all n days.
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
public class StockSpan {

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> span = findSpan(stocks);
        System.out.println(span);
    }

    private static List<Integer> findSpan(int[] stocks) {
        List<Integer> spanList = new ArrayList<>();
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(0, 100));
        spanList.add(0, 1);
        for (int i = 1; i < stocks.length; i++) {
            int currentPrice = stocks[i];
            while (!stack.isEmpty() && stack.peek().getSecond() <= currentPrice) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                int span = i + 1;
                spanList.add(span);
            } else {
                Pair<Integer, Integer> top = stack.peek();
                int index = top.getFirst();
                int span = i - index;
                spanList.add(span);
            }
            stack.add(new Pair<>(i, stocks[i]));
        }

        return spanList;
    }
}
