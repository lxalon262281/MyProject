package com.lx.demo.arithmetic.myleetcode;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法题是leetcode原题：给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）,
 * 其中有些元素出现两次而其他元素出现一次。找到所有出现两次的元素。你可以不用到任何额外空间并在O(n)
 * 时间复杂度内解决这个问题吗
 * 归位法实现
 */
public class 找到所有出现两次的元素 {

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,5,4,1,6};
        List<Integer> result = solution(arr);

        System.out.println(StringUtils.join(result.toArray(),","));

    }

    public static List<Integer> solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr[i] - 1]) {
                swap(arr,i,arr[i] - 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            if (j + 1 != arr[j]) {
                result.add(arr[j]);
            }
        }
        return result;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
