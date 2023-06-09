package com.example.myapplication.codingminutes.recursion;

public class SortedArrayCheck {

    public static void main(String[] args){
     int arr[] = {1,2,3,5,6,4};
     int i=0;
     int n = arr.length;
        System.out.println(isSorted(arr,i,n));
    }

   static boolean isSorted(int arr[],int i,int n){
        //base case
        if(i==n-1){
            return true;
        }
        if(arr[i]<arr[i+1] && isSorted(arr,i+1,n)){
            return true;
        }
        return false;
    }
}
