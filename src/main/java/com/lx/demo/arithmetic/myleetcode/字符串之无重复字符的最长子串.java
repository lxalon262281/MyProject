package com.lx.demo.arithmetic.myleetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是
 "abc"，所以其
 长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是
 "b"
 ，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 
 "wke"
 ，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，
 "pwke"
  是一个子序列，不是子串。
 原文链接：https://blog.csdn.net/HaleyDong/article/details/90768946
 */
public class 字符串之无重复字符的最长子串 {
    /**
     * 思路
     *   维护一个数组dp[]，dp[i]表示到以第i个字符结尾的不包含重复数组的子字符串的最大长度。
             （我们并不保存最大不重复子字符串，只是存储其长度方便后续比较）
       状态转移：
       1. 第i个字符从未出现过，则dp[i] = dp[i-1] + 1；
       2. 第i个字符出现过， 这时我们找出第i个字符最近一次出现的位置index,记两个的距离为d= i-index：
       1） d<=dp[i-1],即这个字符出现在以第i-1个字符结尾的不包含重复数组的子字符串中，则dp[i] = d；
       2） d>dp[i-1], 即这个字符没有出现在以第i-1个字符结尾的不包含重复数组的子字符串中，则dp[i] = dp[i-1] + 1 。
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++){
            char x = s.charAt(i);
            if (s.contains(x + "") ){
                int index = s.lastIndexOf(x, i-1); //index为该字符最近一次出现的位置
                int d = i - index;
                if (d > dp[i-1]) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = d;
                }
            } else {
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
