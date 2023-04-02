package com.example.myapplication.datastructures.array.codingminutes.recursion;

public class FirstOccurence {

    public static void main(String[] args) {
        int arr[] = {7, 2, 5, 1, 9, 6, 14};
        int i = 0;
        int n = arr.length;
        int key = 7;
        int ans = firstOccurence(arr, i, n, key);
        System.out.println("First Occ::" + ans);
        int lastOcc = lastOccurence(arr, i, n, key);
        System.out.println("LastOcc" + lastOcc);
    }

    static int firstOccurence(int arr[], int i, int n, int key) {
        //base case
        if (n == 0 || i == n - 1) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurence(arr, i + 1, n, key);
    }


    static int lastOccurence(int arr[], int i, int n, int key) {
        //base case
        if (n == 0) {
            return -1;
        }
        if(i==n-1){
            if(arr[i]==key){
                return 0;
            }else{
                return -1;
            }
        }
        int subIndex = lastOccurence(arr, i + 1, n, key);
        if (subIndex == -1) {
            if (arr[i] == key) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return subIndex + 1;
        }
    }
}
