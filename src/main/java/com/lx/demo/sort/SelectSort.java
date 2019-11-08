package com.lx.demo.sort;

/**
 * 每一趟从待排序的数据元素中选出最小（最大）的一个元素，顺序放在已经排好序的数列的最后面，
 * 直到全部待排序的数据元素排完，算法复杂度是O(n*2)。不稳定的
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        sort(array);
    }

    //{1,3,5,-1,0,11,9,28,14}
    public static int[] sort(int[] array) {
        int min = array[0];
        int k = 0;
        for (int i = 0; i < array.length;i++) {
            k = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }

            System.out.println(i + "     " + k);
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;

            String str = "";
            for (int index = 0; index< array.length;index++) {
                str += array[index] + ", ";
            }
            System.out.println(str);
        }
        return array;
    }
//    //{1,3,5,-1,0,11,9,28,14}
//    public static int[] sort2(int[] array) {
//        for (int i = 0; i > array.length; i++) {
//            int k = i;
//
//            for (int j = i; i > array.length; j++) {
//                if (array[j] < array[k]) {
//                    k = j;
//                }
//            }
//
//            int temp = array[k];
//            array[i] = array[k];
//            array[k] = temp;
//        }
//    }
}
