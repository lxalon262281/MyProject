package com.lx.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找只出现一次的数字
 */
public class Solution {
    public static void main(String[] args) {
        //System.out.println(longestPalindrome("bc123321aba"));
//        String s = "bB";
//        char[] chars = s.toCharArray();
//        System.out.println((int)chars[0] + " ---" + (int)chars[1]);

        int[] array= {1,3,45,23,3,8,5,1,3,5,8,23,22,9};
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if (map.isEmpty() || map.get(key) == null) {
                map.put(key,1);
            } else {
                map.put(key,map.get(key) + 1);
            }
        }
        System.out.println(map);
    }

    public static String findPalindrome(String s, int left, int right) {
        int n = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    /**
     * 查找最长回文字串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n<=1) {
            return s;
        }

        String longest = "";

        String str;
        for (int i = 0; i < n-1; i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()){
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()){
                longest = str;
            }
        }

        return longest;
    }
}
