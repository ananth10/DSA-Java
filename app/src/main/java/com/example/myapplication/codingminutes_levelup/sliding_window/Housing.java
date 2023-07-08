package com.example.myapplication.codingminutes_levelup.sliding_window;

public class Housing {
    public static void main(String[] args){
        int[] arr = {1,3,2,1,4,1,3,2,1,1,2};
        int k = 8;
        housing(arr,k);
    }

    static void housing(int[] arr,int k){
        int n = arr.length;
        int i=0;
        int j=0;
        int cs=0;

        while (j<n){
            cs+=arr[j];
            j++;

            while (cs>k && i<j){
                cs-=arr[i];
                i++;
            }

            if(cs==k){
                System.out.println(i+", "+(j-1));
            }
        }
    }
}
