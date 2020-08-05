package com.lx.demo.arithmetic.sort.heapsort;

import java.util.Arrays;

/**
 * 堆排序算法
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] a = {9,8,7,6,5,4,3,2,1};
        int[] data = {-1, 5,2, 6, 0};
        int[] a = {-1, 5,2, 6, 0, 3, 9, 4, 8,21,7,1,3,5,8,2,9,0,3,22,100,45,9,13,};
        HeapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 构建大顶堆
     * @param arr
     */
    public static void HeapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(arr,i,arr.length);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr,0,i);
            HeapAdjust(arr,0,i);
        }

    }

    public static void HeapAdjust(int[] arr,int i,int length) {
        int temp = arr[i];//先取出当前元素i
        for(int k= i * 2 + 1;k < length;k = k * 2 + 1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k + 1 < length && arr[k]< arr[k + 1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            System.out.println();
            if (arr[k] >temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
        System.out.println("--- " + Arrays.toString(arr));
    }



    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void heapSort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            heapAdjust(arr,i,arr.length);
        }

        for (int j = arr.length - 1;j > 0; j--) {
            swap(arr,0,j);
            heapAdjust(arr,0,j);
        }

    }

    public static void heapAdjust(int[] arr,int i,int length) {
        int key = arr[i];

        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > key) {
                arr[k] = key;
                i = k;
            } else {
                break;
            }
        }

        arr[i] = key;
    }
}
