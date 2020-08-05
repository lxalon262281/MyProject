package com.lx.demo.arithmetic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求最长公共前缀
 * Longest Common Prefix
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""
 */
public class LCPDemo {
    public static void main(String[] args) {
        String[] strs = { "customer", "car", "cat" };
        // String[] strs = { "customer", "car", null };//空串
        // String[] strs = {};//空串
        // String[] strs = null;//空串


        String[] arr = {"castomer", "c", "casaaaaaat" };
        List<Object> list = new ArrayList<>(Arrays.asList(arr));

        Object[] arr2 = list.toArray();
        System.out.println(Arrays.toString(arr2));
        System.out.println(LCPDemo.solution(strs));// c
    }

    /**
     * 思路很简单！先利用Arrays.sort(strs)为数组排序，
     * 再将数组第一个元素和最后一个元素的字符从前往后对比即可！
     * @param arr
     * @return
     */
    public static String solution(String[] arr) {
        // 如果检查值不合法及就返回空串
        if (!chechStrs(arr)) {
            return "";
        }

        int len = arr.length;
        //保存结果
        StringBuffer result = new StringBuffer();

        //给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(arr);

        int m = arr[0].length();
        int n = arr[len - 1].length();
        int num = Math.max(m,n);

        for (int i = 0; i < num; i++) {
            if (arr[0].charAt(i) == arr[len - 1].charAt(i)) {
                result.append(arr[0].charAt(i));
            } else {
                break;
            }
        }
        return result.toString();
    }

    public static boolean chechStrs(String[] arr) {
        boolean flag = false;

        if (arr != null) {
            for (int i = 0; i < arr.length; i ++) {
                if (arr[i] != null && arr[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
