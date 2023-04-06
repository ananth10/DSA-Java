package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class RatMice {

    public static void main(String[] args) {
        char[][] matrix = {
                {'0', 'X', '0', '0'},
                {'0', '0', '0', 'X'},
                {'X', '0', 'X', '0'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', '0'}
        };
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] b = new int[n][m];
        b[0][0]=1;
        int[][] v = new int[n][m];
        ratChase(matrix,b,v,0,0,n-1,m-1);
        printMatrix(v,n,m);
    }

    static void ratChase(char[][] mat, int[][] b, int[][] v, int row, int col, int n, int m) {
        //base case
        if (row == n && col == m) {
            for (int k = 0; k <=n; k++) {
                for (int l = 0; l <=m; l++) {
                    v[k][l] = b[k][l];
                }
            }
        }

        //Move down
        if(row!=n && mat[row+1][col]!='X'&&b[row+1][col]!=1){
            b[row+1][col] = 1;
            ratChase(mat,b,v,row+1,col,n,m);
            b[row+1][col] = 0;
        }
        //Move up
        if(row>0&&mat[row-1][col]!='X'&&b[row-1][col]!=1){
            b[row-1][col] = 1;
            ratChase(mat,b,v,row-1,col,n,m);
            b[row-1][col] = 0;
        }
        //Move right
        if(col<m&&mat[row][col+1]!='X'&&b[row][col+1]!=1){
            b[row][col+1] = 1;
            ratChase(mat,b,v,row,col+1,n,m);
            b[row][col+1] = 0;
        }
        //Move left
        if(col>0&&mat[row][col-1]!='X'&&b[row][col-1]!=1){
            b[row][col-1] = 1;
            ratChase(mat,b,v,row,col-1,n,m);
            b[row][col-1] = 0;
        }
    }

    static void printMatrix(int[][] mat, int n,int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
