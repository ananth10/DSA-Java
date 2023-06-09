package com.example.myapplication.codingminutes.heaps;

public class MaximumProduct {

    public static void main(String[] args){
        int[] arr = {3,4,5,2};
        int result = maximumProduct(arr);
        System.out.println("Maximum Product is: "+result);
        int result1 = maxProduct(arr);
        System.out.println("Max Product is: "+result1);
    }

    //brute force approach
    static int maximumProduct(int[] arr){
        int maxProduct = 0;
        int n = arr.length;
        for(int i=1;i<n-1;i++){
            int currentMax = (arr[i]-1) * (arr[i+1]-1);
            if(currentMax>maxProduct){
                maxProduct = currentMax;
            }
        }
        return maxProduct;
    }

    static int maxProduct(int[] arr){
        Heap heap = new Heap(arr.length,HeapType.MAX_HEAP);
        for (int i = 0;i< arr.length;i++){
            heap.push(arr[i]-1);
        }
        int p = heap.getTop();
        heap.pop();
        return p* heap.getTop();
    }
}
