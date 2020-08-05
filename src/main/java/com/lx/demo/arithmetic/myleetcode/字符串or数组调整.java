package com.lx.demo.arithmetic.myleetcode;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个字符串chas[],其中只含有字母字符和“*”字符，
 * 现在想把所有“*”全部挪到chas的左边，字母字符移到chas的右边。完成调整函数。
 */
public class 字符串or数组调整 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        char[] chars = s.toCharArray();
        //adjustArray(chars);

        int[] arr = {3,1,5,8,2,6,9,11,4};
        long time1 = System.currentTimeMillis();
        System.out.println(time1);
        adjustArray3(arr);
        System.out.println(System.currentTimeMillis() - time1);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.getStackTrace();
        }

        String s = "*Fetge*SDwt*sdrve***defret123***";
        char[] chars = s.toCharArray();
        long time2 = System.currentTimeMillis();
        System.out.println(time2);
        adjustArray2(chars);
        System.out.println(System.currentTimeMillis() - time2);

//        String replace = s.replace("*", "");
//        String s1 = s.replaceAll("\\d|\\w", "");
//        System.out.println(s1+replace);
    }

    public static void adjustArray(char[] s) {
        if (s.length == 0) {
            return;
        }
        int left = 0,right = s.length - 1,i = 0;

        while (left < right) {
            i = left;
            while (left < right && s[i] == '*') {
                i++;
                left = i;
            }
            int index = i;
            i = right;
            while (left < right && s[i] != '*') {
                i--;
                right = i;
            }
            swap(s, index, right);
            if (left == right) {
                break;
            }
        }

        System.out.println(s);
    }

    public static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    /**
     * 数组调整，偶数放数组右边奇数放数组左边
     * @param arr
     */
    public static void adjustArray2(int[] arr) {
        int i = 0,j = arr.length - 1;

        int[] array = new int[arr.length];
        int even = 0;
        int odd = arr.length - 1;

        for (i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                array[odd--] = arr[i];
            }

            if (arr[i] % 2 == 1) {
                array[even++] = arr[i];
            }
        }

        System.out.println(ArrayUtils.toString(array,","));

    }

    /**
     * 数组调整，偶数放数组右边奇数放数组左边
     * @param arr
     */
    public static void adjustArray3(int[] arr) {

        int[] array = new int[arr.length];
        int even = 0;
        int odd = arr.length - 1;

        for (int i = 0,j = arr.length - 1; i < arr.length; i++,j--) {
            if (arr[i] % 2 == 0) {
                array[odd--] = arr[i];
            }

            if (arr[j] % 2 == 1) {
                array[even++] = arr[j];
            }
        }

        System.out.println(ArrayUtils.toString(array,","));

    }

    /**
     * 数组调整，偶数放数组右边奇数放数组左边
     * @param arr
     */
    public static void adjustArray2(char[] arr) {

        char[] array = new char[arr.length];
        int even = 0;
        int odd = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                array[odd--] = arr[i];
            }

            if (arr[i] == '*') {
                array[even++] = arr[i];
            }
        }

        System.out.println(array);

    }

}
