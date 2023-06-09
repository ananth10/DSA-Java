package com.example.myapplication.codingminutes.backtracking;

public class FindCharacter {

    public static void main(String[] args){
        setUp();
    }

    static void setUp(){
        char[][] matrix = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','H'}
        };
       char key = 'H';
       int i=0;
       int j=0;
       int row = matrix.length-1;
       int col = matrix[0].length-1;
       findChar(matrix,i,j,key,row,col);
    }

    static void findChar(char[][]mat, int i, int j, char key, int row, int col){
        //base case
        if(i>row && j>col){
            return;
        }
        //recursive case
        if(mat[i][j]==key){
            System.out.println("RESULT:"+i+","+j);
            return;
        }
        System.out.println(i+","+j);
        if(i==row){
           j++;
           i=0;
        }else{
            i++;
        }
        findChar(mat,i,j,key,row,col);
    }
}
