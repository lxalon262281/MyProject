package com.lx.demo.wy;

import java.util.Scanner;

public class groupNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            arr[0] = sc.nextInt();
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + sc.nextInt();
            }
            int m = sc.nextInt();
            int query = 0;
            int index = 0;
            for (int i = 0; i < m; i++) {
                query = sc.nextInt();
                index = search(arr, query);
                System.out.print(index + " ");
            }

        }
        sc.close();
    }

    public static int search(int a[], int target) {
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (target >= a[mid]) {
                left = ++mid;
            } else {
                right = mid;
            }
        }
        return left + 1;
    }
}
