package com.company;

import java.util.Scanner;

public class Sudoku {
        public static void main(String args[]) {
            Scanner scan = new Scanner(System.in);
            int n =scan.nextInt();
            int sudoku[][] = new int[n][n];
            for (int i=0;i<n;i++ ) {
                for (int j=0;j<n;j++ ) {
                    sudoku[i][j]=scan.nextInt();
                }
            }
            if (solve(sudoku,n)) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(sudoku[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        public static boolean solve(int sudoku[][], int n)
        {
            int row=-1, col=-1;
            boolean full=true;
            for (int i=0;i<n ;i++ ) {
                for (int j=0;j<n ;j++ ) {
                    if (sudoku[i][j]==0) {
                        full=false;
                        row=i;
                        col=j;
                        break;
                    }
                }
                if(full==false){
                    break;
                }
            }
            if (full) {
                return true;
            }
            for (int num=1;num<=sudoku.length;num++ ){
                if(check(row,col,num,sudoku)){
                    sudoku[row][col]=num;
                    if(solve(sudoku,n)){
                        return true;
                    }
                    else{
                        sudoku[row][col]=0;
                    }
                }
            }
            return false;
        }

        public static boolean check(int row, int col, int num,int sudoku[][])
        {
            for (int i=0;i<sudoku.length ;i++ ) {
                if (sudoku[row][i]==num) {
                    return false;
                }
            }
            for (int i=0;i<sudoku.length ;i++ ) {
                if (sudoku[i][col]==num) {
                    return false;
                }
            }
            int r=row/3;
            int c=col/((sudoku.length/3));
            for (int i=r*3;i<r*3+3 ;i++ ) {
                for (int j=c*(sudoku.length/3);j<c*(sudoku.length/3)+(sudoku.length/3);j++ ) {
                    if (sudoku[i][j]==num) {
                        return false;
                    }
                }
            }
            return true;
        }
}
