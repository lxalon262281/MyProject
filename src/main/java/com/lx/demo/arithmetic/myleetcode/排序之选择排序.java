package com.lx.demo.arithmetic.myleetcode;

public class 排序之选择排序 {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        selectSort(array);
        System.out.println();
    }

    public static void selectSort(int[] arr) {
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            index = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] > arr[index]) {
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}
