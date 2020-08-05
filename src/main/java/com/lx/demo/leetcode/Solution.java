package com.lx.demo.leetcode;

import java.util.HashSet;

public class Solution {
    /**
     * 不重复字串长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int resLength = 0;
        int strLength = s.length();
        int i = 0, j = 0;
        HashSet<String> hashSet = new HashSet<String>();

        while (i < strLength && j < strLength){
            String oneStrJ = s.substring(j,j+1);
            if (!hashSet.contains(oneStrJ)){
                hashSet.add(oneStrJ);
                j++;
                resLength = Math.max(resLength,j-i);
            } else {
                String oneStrI = s.substring(i, i+1);
                hashSet.remove(oneStrI);
                i++;
            }
        }
        return resLength;
    }

    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len;
        int maxlen = 0;
        String palindrome ="";
        if (s.length() == 0 || s.length() == 1){
            return s;
        }

        for (int i = 0;i < s.length();i++){
            for (int j=i;j < s.length();j++) {
                len = j - i;
                if (check(s.substring(i, j + 1))) {
                    if (maxlen <= len) {
                        maxlen = len;
                        palindrome = s.substring(i, j + 1);
                    }
                }
            }
        }
        return palindrome;
    }

    /**
     * 判断字符串是否为回文串
     * @param s
     * @return
     */
    public static boolean check(String s){
        int l = 0;
        int r = s.length()-1;
        while (l < r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 32位带符号整数反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        if(x == 0 || x <=Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }

        int res = 0;
        int n = 0;
        while(x != 0){
            n++;
            if (n == 10){
                if (x < 0){
                    if (res < Integer.MIN_VALUE / 10){
                        return 0;
                    }
                } else{
                    if (res > Integer.MAX_VALUE / 10){
                        return 0;
                    }
                }
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
//        String str = "abcabcba";
//        System.out.println(lengthOfLongestSubstring(str));
        String str = "babad";
        //System.out.println(longestPalindrome(str));
        int x = -1563847498;


    }
}
