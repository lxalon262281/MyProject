package com.lx;


/**
 * 给一个有序排列的整数数组a[n],整数数组有且仅有一个值缺失，求当前缺失的值。
 * 例子 a[10]={0,1,2,3,5,6,7,8,9,10}，返回缺失的值为4.
 * 其中，方法一和方法二都是递归的思路，只不过方法一是用了二分法求和的递归思路，
 * 方法二是利用数组的特点进行递归，递归仍然使用二分的思想。
 */
public class QueryLackedInt {
    //       方法一：根据数组特性即可求出缺失的值
    public static int getNum1(int[] data) {
        if (data == null || data.length == 0) return -1;
        if (data[0] != 0) return 0;
        int len = data.length;
        int sum1 = getSum(data, 0, len - 1);
        int sum2 = (len + 1) * (data[0] + data[len - 1]) / 2;
        return sum2 - sum1;
    }

    public static int getSum(int[] data, int low, int high) {
        if (data == null || data.length == 0) return -1;
        if (low == high) {
            return data[low];
        } else {
            int mi = (low + high) >> 1;
            return getSum(data, low, mi) + getSum(data, mi + 1, high);
        }
    }

    //       方法二：使用两个指针进行递归
    public static int getNum2(int[] data) {
        if (data == null || data.length == 0) return -1;
        if (data.length >= 1 && data[0] != 0) return 0;
        return getRecursion(data, 0, data.length-1);
    }

    private static int getRecursion(int[] data, int left, int right) {
        int mid = (left + right) / 2;
        if (right == left && data[left] != left) return left;
        if (data[mid] == mid) {
            return getRecursion(data, mid+1, right);
        } else {
            return   getRecursion(data, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7,  9, 10, 11, 12,13, 14, 15};
        int[] b = null;
        int[] c = {1, 2};
        System.out.println(getNum1(a));
        System.out.println(getNum1(b));
        System.out.println(getNum1(c));
        System.out.println(getNum2(a));
        System.out.println(getNum2(b));
        System.out.println(getNum2(c));


    }
}
