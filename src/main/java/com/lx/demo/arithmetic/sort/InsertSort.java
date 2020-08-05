package com.lx.demo.arithmetic.sort;

/**
 * 插入排序：每次将一个待排序的数据元素，插入到前面已经排好序的数列中的适当位置，
 * 使数列依然有序；直到待排序数据元素全部插入完为止。算法的时间复杂度是o(n*2）。稳定的
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        sort3(array);
        String str = "";
        for (int k = 0; k< array.length;k++) {
            str += array[k] + ", ";
        }
        System.out.println(str);
    }


    // {1,3,5,-1,0,11,9,28,14};
    public static void sort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length;i++) {
            temp = array[i];
            int j = 0;
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j - 1];
                } else {
                    break;
                }
            }
            array[j] = temp;

        }
    }

    //{1,3,5,-1,0,11,9,28,14}
    public static void sort2(int[] array) {
        int i,j;
        int flag;
        for (i = 0; i < array.length; i++) {
            flag = array[i];
            for (j = i; j > 0; j--) {
                if (array[j-1] > flag ) {
                    array[j] = array[j+1];
                } else {
                    break;
                }
            }

            array[j] = flag;
        }

    }

    //{1,3,5,-1,0,11,9,28,14}
    public static void sort3(int[] array) {
        int i,j,temp;
        for (i = 0; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    array[j] = array[j-1];
                } else {
                    break;
                }
            }
            array[j] = temp;
        }
    }

}
