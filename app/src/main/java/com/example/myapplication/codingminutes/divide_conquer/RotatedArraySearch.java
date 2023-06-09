package com.example.myapplication.codingminutes.divide_conquer;

public class RotatedArraySearch {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int s = 0;
        int e = arr.length - 1;
        int key = 3;
        int index = rotateSearch(arr, s, e, key);
        System.out.println("KEY INDEX:" + index);
    }

    static int rotateSearch(int[] arr, int s, int e, int key) {
        while (s <= e) {
            int mid = (s + e) / 2;
            //simple case
             if(arr[mid]==key){
                 return mid;
             }
            //case 1
            if (arr[s] <= arr[mid]) {
                if (key >= arr[s] && key <= arr[mid]) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else { //case 2
                if (key >= arr[mid] && key <= arr[e]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
}
