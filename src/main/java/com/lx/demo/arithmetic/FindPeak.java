package com.lx.demo.arithmetic;

/**
 * 求先递增后递减数组最大值的下标
 */
public class FindPeak {
    public static void main(String[] args) {

    }

    public static int solution(int[] num) {
        if (num.length == 1) {
            return 0;
        }

        if (num[0] > num[1]) {
            return 0;
        }

        int index = num.length - 1;

        if (num[index] > num[index -1]) {
            return index;
        }

        int i = 0;
        int j = index;

        while (i < j) {
            int mid = (i + j) / 2;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            }
            if (num[mid] > num[mid - 1]) {
                i = mid + 1;
            }
            if (num[mid] > num[mid + 1]) {
                j = mid - 1;
            }
        }
        return -1;
    }
}
