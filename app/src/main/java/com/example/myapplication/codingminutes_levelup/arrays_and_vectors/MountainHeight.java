package com.example.myapplication.codingminutes_levelup.arrays_and_vectors;

public class MountainHeight {

    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4, 5, 4, 3, 2, 0, 1, 2, 3, -2, 4};
        int result = largestMountain(arr);
        System.out.println("Result: " + result);
    }

    static int largestMountain(int[] arr) {
        int n = arr.length;
        int largest = 0;

        //first and last 2nd elements will never be a peak
        for (int i = 1; i < n - 2; ) {

            //check the current element is a peak or not(peak means previous and next element should be less than current element)
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int count = 1;
                //calculate backwards length
                int j = i;
                while (j >= 1 && arr[j] > arr[j - 1]) {
                    count++;
                    j--;
                }
                //calculate forwards length
                while (i <= n - 2 && arr[i] > arr[i + 1]) {
                    count++;
                    i++;
                }
                largest = Math.max(largest, count);
            } else {
                //if no peak found then move to next element
                i++;
            }
        }
        return largest;
    }
}
