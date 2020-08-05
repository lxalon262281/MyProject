package com.lx.demo.arithmetic.sort;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;

/**
 * 每一趟从待排序的数据元素中选出最小（最大）的一个元素，顺序放在已经排好序的数列的最后面，
 * 直到全部待排序的数据元素排完，算法复杂度是O(n*2)。不稳定的
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        sort(array);
        System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
    }

    //{1,3,5,-1,0,11,9,28,14}System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
    public static int[] sort(int[] array) {
        int index;
        for (int i = 0; i < array.length;i++) {
            index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index]) {
                    index = j;
                }
            }

            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;

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
