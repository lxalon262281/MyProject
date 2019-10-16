package com.lx.sort;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] array = {5,8,3,0,-1,4,9,7};
        insetSort(array);
    }

    public static void insetSort(int[] array) {
        int i,j,temp;
        for (i = 0; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0; j--) {
                if (array[j - 1] > temp) {
                    //array[j] = array[j - 1];
                    swap(array,j,j-1);
                } else {
                    break;
                }
            }
            //array[j] = temp;
            System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
        }
    }

    public static void swap(int[] array,int low,int high) {
        int flag = array[low];
        array[low] = array[high];
        array[high] = flag;
    }
}
