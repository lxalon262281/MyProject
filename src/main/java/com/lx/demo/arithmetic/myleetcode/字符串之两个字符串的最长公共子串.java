package com.lx.demo.arithmetic.myleetcode;

/**
 * https://blog.csdn.net/qq_25800311/article/details/81607168?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1
 */
public class 字符串之两个字符串的最长公共子串 {

    public static void main(String[] args) {
        String[] s1 = {"a","b","c","b","c","e","d"};
        String[] s2 = {"a","c","b","c","b","c","e","f"};

        solution2(s1,s2);
    }

    public static void solution(String[] s1, String[] s2) {
        int s1len = s1.length,s2len = s2.length;

        int[][] arr = new int[s1len][s2len];

        int maxlen = 0,maxend = 0;
        for (int i = 0; i < s1.length; i ++) {
            for (int j = 0; j < s2len; j++) {
                if (s1[i] == s2[j]) {

                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                } else {
                    arr[i][j] = 0;
                }

                if (arr[i][j] > maxlen) {
                    maxlen = arr[i][j];
                    maxend = i;
                }
            }
        }
        System.out.printf("");
        return;
    }


    public static void solution2(String[] s1, String[] s2) {
        int s1len = s1.length,s2len = s2.length;

        int[][] dp = new int[s1len][s2len];
        int maxlen = 0, maxend = 0;

        /**
         * String[] s1 = {"a","b","c","b","c","e","d"};
         String[] s2 = {"a","c","b","c","b","c","e","f"};
         */
        for (int i = 0; i < s1len; i++) {
             for (int j = 0; j < s2len; j++) {
                 if (s1[i] == s2[j]) {
                     if (i == 0 || j == 0) {
                         dp[i][j] = 1;
                     } else {
                         dp[i][j] = dp[i - 1][j - 1] + 1;
                     }
                 } else {
                     dp[i][j] = 0;
                 }
                 if (maxlen < dp[i][j]) {
                     maxlen = dp[i][j];
                     maxend = i;
                 }
             }
        }

        int start = maxend - maxlen + 1;
        System.out.println(start + "  " + maxlen);

    }
}
