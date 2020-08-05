package com.lx.demo.arithmetic.myleetcode;

public class 排序之快速排序 {
    public static void main(String[] args) {
        int[] array = {1,3,5,-1,0,11,9,28,14};
        quickSort(array,0,array.length - 1);
        System.out.println();
    }

    public static void quickSort(int[] arr,int low,int high) {
        int key = 0;

        if (low < high) {
            key = partition(arr,low,high);
            quickSort(arr,low,key -1);
            quickSort(arr,key + 1,high);
        }
    }

    public static int partition(int[] arr,int low,int high) {
        int temp = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }

            swap(arr,low,high);

            while (low < high && arr[low] <= temp) {
                low++;
            }

            swap(arr,low,high);
        }

        return low;
    }

    public static void swap(int[] arr,int low,int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }

}
