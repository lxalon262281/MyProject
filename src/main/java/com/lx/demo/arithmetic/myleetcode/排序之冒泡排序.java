package com.lx.demo.arithmetic.myleetcode;

public class 排序之冒泡排序 {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        bubbleSort(array);
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
