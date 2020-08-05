package com.lx.demo.arithmetic.myleetcode;

public class 不循环找出数组最大值 {
    public static int i=0;
    public static int max =0;
    public static int len =0;

    public static void main(String[] args) {
        int a[]={1,2,4,6,2,8,3};
        len = a.length - 1;
        find(max, i,a);
    }
    public static void find(int max,int i,int a[]){
        if (a[i] > max) {
            max = a[i];
        }

        if (i < len){
            i++;
            find(max,i,a);
        } else {
            System.out.println(max);
        }

    }


    /**
     * 递归实现
     * @param max
     * @param i
     * @param a
     */
    public static void findMax(int max,int i,int a[]) {
        if (a[i] > max) {
            max = a[i];
        }

        if (i < len) {
            i++;
            findMax(max,i,a);
        } else {
            System.out.printf("max = " + max);
        }
    }
}
