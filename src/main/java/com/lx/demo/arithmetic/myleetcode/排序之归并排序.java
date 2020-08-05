package com.lx.demo.arithmetic.myleetcode;

import java.util.Arrays;

public class 排序之归并排序 {
    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {1};
        int[] arr3 = new int[1];

        System.out.println();
    }
    public void merge(int A[], int m, int B[], int n) {
        int i = 0,j = 0;
        while (i < m && j < n){
            if (A[i] <= B[j]){
                i++;
            } else {
                for (int x = m;x > i;x-- ){
                    A[x]=A[x-1];
                }
                A[i++]=B[j++];
                m++;
            }
        }
        while (i >= m && j < n){
            A[i++]=B[j++];
        }
    }



}
