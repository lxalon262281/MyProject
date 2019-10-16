package com.lx.sort;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] array = {5,8,3,0,-1,4,9,7};
        quickSort(array,0,array.length -1);
    }

    public static void quickSort(int[] array,int low,int high) {
        int index = 0;
        if (low < high) {
            index = partition(array,low,high);
            quickSort(array,low,index -1);
            quickSort(array,index + 1,high);
        }
    }

    public static int partition(int[] array,int low,int high) {
        int flag = array[low];
        while (low < high) {
            if (low < high && array[high] >= flag) {
                high--;
            }
            swap(array,low,high);
            System.out.println();

            if (low < high && array[low] <= flag) {
                low++;
            }
            swap(array,low,high);
        }
        System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
        return low;
    }


    public static void swap(int[] array,int low,int high) {
        int flag = array[low];
        array[low] = array[high];
        array[high] = flag;
    }
}
