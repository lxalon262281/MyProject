package com.lx.demo.arithmetic.myleetcode;


/**
 * /**
 * 动态规划：剪绳子
 * 给一根长度为n的绳子，请把绳子剪成m段(m,n都是整数且1)，每段绳子的长度相乘最大乘积是多少？
 * 如绳子长度为8，当分别为2，3，3时，此时最大乘积18
 */
public class 动态规划之剪绳子 {
    public static void main(String[] args) {

    }

    /**
     * 本方法思想：用动态规划自下而上的计算，先算出n为1、2、3。。的最大乘积，
     * 知道小的以后在去算更大的乘积。比如n为4时候最大的可能只能在1*3,2*2之间取得；n为5时，
     * 只能在f(1)*f(4),f(2)*f(3)之间取得,而f(2),f(3),f(4)之前均已经求出。
     * @param n
     * @return
     */
    public static int solution(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        int arr[] = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        int max = 0;
        int temp = 0;
        for (int i = 4; i < n; i++) {
            max = 0;
            for (int j = 1; j <= n / 2; j++) {
                temp = arr[i] * arr[n - j];
                if (max < temp) {
                    max = temp;
                    arr[i] = max;
                }
            }
        }
        return arr[n];
    }
}
