package com.lx;


/**
 * 求1的阶乘到n的阶乘的和
 */
public class GetSumFactorial {
    public static long getAddFactorial(long n) {
        if (n < 1) {
            return -1;
        }
        long sum=0,start=1,end=n;
        long mid;
        while (start<=end){
            sum+=getSingleFactorial(end);
            end--;

        }
        return sum;


    }

    public static long getSingleFactorial(long i) {
        if(i < 1) {
            return -1;
        }
        if(i == 1) {
            return 1;
        }

        return getSingleFactorial(i-1) * i;

    }

    public static void main(String[] args) {
        System.out.println(getAddFactorial(4));
    }
}
