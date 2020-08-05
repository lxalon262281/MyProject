package com.lx.demo.arithmetic.myleetcode;

public class 动态规划之爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
    public static int climbStairs(int n) {
        if(n  <= 2) {
            return n;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for(int i = 2; i < n; i++) {
            arr[i] = arr[i -1] + arr[i - 2];
        }

        return arr[n -1];

    }
}
