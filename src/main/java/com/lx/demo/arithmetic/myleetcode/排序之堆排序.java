package com.lx.demo.arithmetic.myleetcode;

public class 排序之堆排序 {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        heapSort(array);
        System.out.println();
    }

    public static void heapSort(int[] arr) {
        //构建大顶堆
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }

        for (int i = arr.length  - 1; i > 0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i);
        }
    }

    public static void adjustHeap(int[] arr,int i,int len) {
        int temp = arr[i];

        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;

    }

    public static void swap(int[] arr,int low,int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
