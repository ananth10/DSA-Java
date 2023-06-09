package com.example.myapplication.codingminutes.vector;

public class RotateImage {

    public static void main(String[] args) {
//        rotateImageClockwise();
//        rotateImageAntiClockWise();
        rotate();
    }


    static void rotateImageClockwise() {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);
        int l = 0;
        int r = matrix.length-1;

        while (l < r) {
            for (int i = 0; i<r; i++) {
                int top = l;
                int bottom = r;

                //store top left in the variable
                int topLeft = matrix[top][l+i];

                //move bottom left value to top left
                matrix[top][l+i] = matrix[bottom-i][l];

                //move bottom right value into bottom left
                matrix[bottom-i][l] = matrix[bottom][r-i];

                //move top right value to bottom right
                matrix[bottom][r-i] = matrix[top+i][r];

                //move stored top left value to top right
                matrix[top+i][r] = topLeft;
            }

            r--;
            l++;
        }

        //print rotate 2d array

        printMatrix(matrix);
    }

    static void rotateImageAntiClockWise(){
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);
        int l = 0;
        int r = matrix.length-1;

        while (l<r){
            for(int i=0;i<r;i++){
                int top = l;
                int bottom=r;

                //store top right value in the variable
                int topRight = matrix[top][r-i];

                //move bottom right into top right
                matrix[top][r-i] = matrix[bottom-i][r];

                //move bottom left into bottom right
                matrix[bottom-i][r] = matrix[bottom][l+i];

                //move top left into bottom left
                matrix[bottom][l+i] = matrix[top+i][l];

                //move top right to top left
                matrix[top+i][l] = topRight;
            }

            l++;
            r--;
        }

        //print rotate 2d array

        printMatrix(matrix);
    }

    static void printMatrix(int mat[][]){
        System.out.println();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }



    static void swap(int[][] v, int i, int j, int k, int l){
        int temp = v[i][j];
        v[i][j] = v[k][l];
        v[k][l] = temp;
    }
    static void rotate() {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = matrix.length;
        int a = 0;
        int b = n-1;
        while(a<b){
            for(int i=0;i<(b-a);++i){
                swap(matrix, a,a + i, a+i, b);
                printMatrix(matrix);
                swap(matrix, a,a+i, b, b-i);
                printMatrix(matrix);
                swap(matrix, a,a+i, b-i, a);
                printMatrix(matrix);
            }
            printMatrix(matrix);
            ++a;
            --b;
        }
    }

}
