package com.example.myapplication.codingminutes.recursion;

public class Increase {

    public static void main(String[] args){
//        int s=1;
//        int e=10;
//        increase(s,e);
//        System.out.println("///////////////");
//        decrease(s,e);

        increase1(5);
        decrease1(5);
    }

    static void increase(int start,int end){
        //base case
        if(start>end){
            return;
        }
        System.out.println(start);
        start +=1;
        increase(start,end);
    }

    static void decrease(int start,int end){
        //base case
        if(end<start){
            return;
        }
        System.out.println(end);
        end -=1;
        decrease(start,end);
    }

    static void decrease1(int n){
        //base case
        if(n==0){
            return;
        }
        System.out.println(n);
        decrease1(n-1);
    }
    static void increase1(int n){
        //base case
        if(n==0){
            return;
        }
        increase1(n-1);
        System.out.println(n);
    }
}
