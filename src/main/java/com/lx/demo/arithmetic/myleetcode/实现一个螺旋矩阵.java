package com.lx.demo.arithmetic.myleetcode;

public class 实现一个螺旋矩阵 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n*n;
        int num = 1;
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        while(num <= total) {
            // traverse right (y changes)
            for(int y=colBegin; y<=colEnd; y++)
                res[rowBegin][y] = num++;
            rowBegin++; // move down one row

            // traverse down (x changes)
            for(int x=rowBegin; x<=rowEnd; x++)
                res[x][colEnd] = num++;
            colEnd--; // move left one column
            // traverse left (y changes)
            for(int y=colEnd; y>=colBegin; y--)
                res[rowEnd][y] = num++;

            rowEnd--; // move up one row

            // traverse up (x changes)
            for(int x=rowEnd; x>=rowBegin; x--)
                res[x][colBegin] = num++;
            colBegin++; // move right one column
        }

        return res;
    }


    public int[][] generateMatrix2(int n) {
        int total = n * n;
        int[][] arr = new int[n][n];

        int rowStart = 0;
        int rowEnd = n -1;
        int colStart = 0;
        int colEnd = n -1;

        int sum = 1;

        while (sum <= total) {
            for (int y = colStart; y <= colEnd; y++) {
                arr[rowStart][y] = sum++;
            }
            rowStart++;

            for (int x = rowStart; x <= rowEnd; x++) {
                arr[x][colEnd] = sum++;
            }
            colEnd--;

            for (int y = colEnd; y >= colStart; y--) {
                arr[rowEnd][y] = sum++;
            }
            rowEnd--;

            for (int x = rowEnd; x >= rowStart; x--) {
                arr[x][rowStart] = sum++;
            }
            colStart++;
        }

        return arr;
    }
}
