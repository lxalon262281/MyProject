package com.lx.demo.arithmetic.myleetcode;


/**
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子序列的长度。
 * 例如，str1="1A2C3”，str2="B1D23”，”123"是最长公共子序列，
 * 那么两字符串的最长公共子序列的长度为3。
 * https://www.jianshu.com/p/009bad6274be
 */
public class 动态规划之最长子序 {
    public static int findLCS(String A, int n, String B, int m) {
        return core(A, n, B, m);
    }

    public static int core(String A, int n, String B, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        int[][] dp = new int[n][m];
        char[] result = new char[10];
        int index = 0;
        // 初始化第0行
        for (int i = 0; i < m; i++) {
            if (A.charAt(0) == B.charAt(i)) {
                for (int j = i; j < m; j++) {
                    dp[0][j] = 1;
                }
                break;
            } else {
                dp[0][i] = 0;
            }
        }
        // 初始化第0列
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                for (int j = i; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(result);
        return dp[n - 1][m - 1];
    }


    public static int core2(String A, int n, String B, int m) {
       int[][] dp = new int[m][n];
       for (int i = 0; i < m; i++) {
           if (A.charAt(0) == B.charAt(i)) {
               for (int j = i; j < n; j++) {
                   dp[0][j] = 1;
               }
               break;
           } else {
               dp[0][i] = 0;
           }
       }
        for (int i = 0; i < m; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                for (int j = i; j < n; j++) {
                    dp[i][0] = 1;
                }
                break;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
           for (int j = 1; j < m; j++) {
               if (A.charAt(i) == B.charAt(j)) {
                   dp[i][j] = dp[i - 1][j - 1] + 1;
               } else {
                   dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]) ;
               }
           }
        }
        return dp[n -1][n - 1];
    }

    public static void main(String[] args) {
//        String A = "1A2C3";
//        int n = A.length();
//        String B = "B1D23";
        String A = "ABCB";
        int n = A.length();
        String B = "BDCA";
        int m = B.length();
        int res = findLCS(A, n, B, m);
        System.out.println(res);
    }
}
