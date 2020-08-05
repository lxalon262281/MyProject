package com.lx.demo.arithmetic.myleetcode;

public class Test2 {

    public static void main(String[] args) {

    }

    public static void findTopK(int[] array, int k) {
        int[] arr = new int[k];
        int index = 0;

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                arr[index] = max;
                max = arr[i];
            }
        }
    }
}
