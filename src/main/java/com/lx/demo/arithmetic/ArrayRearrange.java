package com.lx.demo.arithmetic;

public class ArrayRearrange {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 2, 2, 4, 4, 5, 5, 7};
        arr = rearrange(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] rearrange(int[] array) {
        int i, j;
        int length = array.length;

        i = 0;
        j = 1;
        while (1 == 1) {
            while (array[i] % 2 == 1) {
                i += 2;
            }

            while (array[j] % 2 == 0) {
                j += 2;
            }
            swap(array, i, j);
            i += 2;
            j += 2;
            if (j >= length || i >= length) {
                break;
            }
        }
        return array;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reorder(int[] arr) {
        if (arr == null) {
            System.out.println("the array is null");
            return;
        }
        int len = arr.length;
        int ou = 0;
        int ji = 1;
        while (ou < len && ji < len) {
            if (arr[ou] % 2 == 0) {
                ou = ou + 2;
            }
            if (arr[ji] % 2 == 1) {
                ji = ji + 2;
            }
            if (ou < len && ji < len) {//该条件的目的是先判断数组下标是否出界，如果不加该条件判断，程序可能会有数组下标越界错误
                if (arr[ou] % 2 == 1 && arr[ji] % 2 == 0) {
                    int temp = arr[ou];
                    arr[ou] = arr[ji];
                    arr[ji] = temp;
                }
            }
        }

    }
}