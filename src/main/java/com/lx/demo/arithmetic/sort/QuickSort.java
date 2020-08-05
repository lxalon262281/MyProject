package com.lx.demo.arithmetic.sort;


import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.Arrays;

/**
 * 快速排序：在当前无序区 R[1..H]中任取一个数据元素作为比较的"基准"(不妨记为 X)，
 * 用此基准将当前无序区划分为左右两个较小的无序区：R[1..I-1]和 R[I+1..H]，
 * 且左边的无序子区中数据元素均小于等于基准元素，右边的无序子区中数据元素均大于等于基准元素，
 * 而基准 X 则位于最终排序的位置上，
 * 即R[1..I-1]≤X.Key≤R[I+1..H](1≤I≤H)，当 R[1..I-1]和 R[I+1..H]均非空时，
 * 分别对它们进行上述的划分过程，直至所有无序子区中的数据元素均已排序为止。
 * 最理想情况算法时间复杂度 O(nlogn)，最坏O(n^2) 。不稳定。
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5,8,3,0,-1,4,9,7};
        quickSort(array);
    }


    private static void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }


    // {1,3,5,-1,0,11,9,28,14}
    private static int partition(int[] array, int low, int high) {
        int key = array[low];
        System.out.println("low :" + low + " key " + key);
        while (low < high) {
            while (low < high && array[high] >= key) {
                high--;
            }
            swap(array, low, high);
            while (low < high && array[low] <= key) {
                low++;
            }
            swap(array, low, high);
        }
        System.out.println(ToStringBuilder.reflectionToString(Arrays.asList(array)));
        return low;
    }

    private static void quickSort(int[] array) {
        int result = quick(array, 0, array.length - 1);
        System.out.println(result);
    }

    private static int quick(int[] array, int low, int high) {
        int key = 0;
        if (low < high) {
            key = partition(array, low, high);
            quick(array, low, key - 1);
            quick(array, key + 1, high);
        }
        return key;

    }

}

