package com.example.myapplication.datastructures.array.codingminutes.backtracking;

public class GridPath {

    public static void main(String[] args){
      int ans = gridPath(0,0,3,3);
        System.out.println(ans);
    }

    static int gridPath(int currentRow,int currentCol,int row, int col){
        //base case
        if(currentRow==row-1 && currentCol==col-1){
            return 1;
        }
        if(currentRow>=row || currentCol>=col){
            return 0;
        }

        int ans = gridPath(currentRow+1,currentCol,row,col)  + gridPath(currentRow,currentCol+1,row,col);
        return ans;
    }
}
