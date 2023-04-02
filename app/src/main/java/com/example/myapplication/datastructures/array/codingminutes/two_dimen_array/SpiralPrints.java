package com.example.myapplication.datastructures.array.codingminutes.two_dimen_array;


public class SpiralPrints {


    public static void  main(String[] args){
        int array[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int rows = 4;
        int columns = 4;
        spiralPrint(array,rows,columns);
    }

    static void spiralPrint(int arr[][], int rows, int columns){
        int startRow = 0;
        int endRow = rows-1;
        int startColumn = 0;
        int endColumn = columns-1;

        //outer loop (traverse array boundary)
        while (startColumn<=endColumn && startRow<=endRow){
            //startRow
            for(int col=startColumn;col<=endColumn;col++){
                System.out.println(arr[startRow][col]+" "); //row is fixes
            }
            //end column
            for (int row=startRow+1;row<=endRow;row++){
                System.out.println(arr[row][endColumn]+" "); //column is fixed
            }
            //endRow
            for (int col = endColumn-1;col>=startColumn;col--){
                if(startRow==endRow){
                    break;
                }
                System.out.println(arr[endRow][col]+" "); //row is fixed
            }
            //startColumn
            for(int row=endRow-1;row>=startRow+1;row--){
                if(startColumn==endColumn){
                    break;
                }
                System.out.println(arr[row][startColumn]+" "); //column is fixed
            }

            startRow++;
            startColumn++;
            endColumn--;
            endRow--;
        }
    }
}
