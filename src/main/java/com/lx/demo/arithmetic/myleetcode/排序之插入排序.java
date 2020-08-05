package com.lx.demo.arithmetic.myleetcode;

public class 排序之插入排序 {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        inserSort(array);
        System.out.println();
    }

    public static void inserSort(int[] arr) {
        int temp = arr[0];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }
}
