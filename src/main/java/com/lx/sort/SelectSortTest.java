package com.lx.sort;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;

public class SelectSortTest {
    public static void main(String[] args) {
        int[] array = {5,8,3,0,-1,4,9,7};
        selectSort(array);
    }

    public static void selectSort(int[] array) {
        int index = 0;
        int flag;
        for (int i = 0; i < array.length; i++) {
            flag = array[i];
            for (int j = i + 1;j < array.length;j++) {
                if (array[j] < flag) {
                    index = j;
                    flag = array[index];
                }
            }
            swap(array,index,i);
            System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
        }
    }

    public static void swap(int[] array,int low,int high) {
        int flag = array[low];
        array[low] = array[high];
        array[high] = flag;
    }
}
