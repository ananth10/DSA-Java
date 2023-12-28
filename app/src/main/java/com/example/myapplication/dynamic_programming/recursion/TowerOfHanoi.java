package com.example.myapplication.dynamic_programming.recursion;

public class TowerOfHanoi {

    public static void main(String[] args){
        int n = 2;
        char from = 'A',helper='B',to='C';
        towerOfHanoi(n,from,helper,to);
    }

    private static void towerOfHanoi(int n, char from, char helper, char to) {
        //base case
        if(n==0){
            return;
        }
        //recursive case
        towerOfHanoi(n-1,from,to,helper);
        System.out.println(from+"->"+to);
        towerOfHanoi(n-1,helper,from,to);
    }
}
