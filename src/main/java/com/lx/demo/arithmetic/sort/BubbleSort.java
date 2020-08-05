package com.lx.demo.arithmetic.sort;

/**
 * 冒泡排序，每次两两比较，发现两个数据元素的次序相反时进行交换，直到没有反序的数据元素为止。时间复杂度是O(n*2)。稳定的。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        sort(array);
        String str = "";
        for (int k = 0; k< array.length;k++) {
            str += array[k] + ", ";
        }
        System.out.println(str);
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j< array.length;j++ ) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return null;
    }
}
