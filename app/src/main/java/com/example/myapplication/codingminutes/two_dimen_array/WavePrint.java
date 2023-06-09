package com.example.myapplication.codingminutes.two_dimen_array;

import java.util.ArrayList;

public class WavePrint {

    public static void main(String[] args){
        int arr[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

       int rows = 4;
       int columns = 4;

        wavePrint(arr,rows,columns);
    }

    static void wavePrint(int array[][],int rows, int columns){
        int startRow = 0;
        int endRow = rows-1;
        int startColumn = 0;
        int endColumn = columns-1;

       while (endColumn>=startColumn){
           while (startRow<=endRow){
               System.out.println(array[startRow][endColumn]+ " ");
               startRow++;
           }
           endColumn--;
           startRow=0;
           while (endRow>=startRow){
               System.out.println(array[endRow][endColumn]+ " ");
               endRow--;
           }
           endColumn--;
           endRow=rows-1;
       }
    }

    public static ArrayList<Integer> WavePrint(int m, int n, ArrayList<ArrayList<Integer>> arr)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int i, j = n - 1, wave = 1;

    /* m 	- Ending row index
        n 	- Ending column index
        i, j 	- Iterator
        wave 	- for Direction
        wave = 1 - Wave direction down
        wave = 0 - Wave direction up   */
        while (j >= 0) {

            // Check whether to go in
            // upward or downward
            if (wave == 1) {

                // Print the element of the matrix
                // downward since the value of wave = 1
                for (i = 0; i < m; i++)
                    res.add(arr.get(i).get(j));
                wave = 0;
                j--;
            }
            else {

                // Print the elements of the
                // matrix upward since the value
                // of wave = 0
                for (i = m - 1; i >= 0; i--)
                    res.add(arr.get(i).get(j));
                wave = 1;
                j--;
            }
        }
        return res;
    }

}
