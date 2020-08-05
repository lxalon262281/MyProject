package com.lx;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String s = "aabbdfgrwwweetyghjhdddddsss";
        System.out.println(longestNum3(s));
        //System.out.println(longestNum2("1422331sdsfgd4115sd231234567654fghtsg"));
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String str = in.nextLine();
            StringBuilder sb = new StringBuilder();
//            // i记录连续子串的头部
//        String str = "aasdfrrgg";
//            for (int i = 0; i < str.length(); i++) {
//                // j为移动指针，记录连续子串的尾部
//                int j = i;
//                // 若后一个字符跟当前一样，则j后移一位
//                while (j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)) {
//                    j++;
//                }
//                if (i == j) {
//                    // ij相等说明不是连续的，拼接之
//                    sb.append(str.charAt(i));
//                } else {
//                    // 当前子串是连续，跳过
//                    i = j;
//                }
//            }
//            if (sb.toString().equals(""))
//                System.out.println("no");
//            else
//                System.out.println(sb);

    }

    public static String longestNum3(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            int j = i;
            while (j+1 < str.length() && str.charAt(j) == str.charAt(j + 1)) {
                j++;
            }
            if (i == j) {
                sb.append(str.charAt(i));
            } else {
                i = j;
            }
        }
        return sb.toString();
    }

    public static String longestNum2(String str) {
        int ostart = 0,nstart = 0,olen = 0,nlen = 0;

        for (int i = 1; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) && Character.isDigit(str.charAt(i - 1))) {
                nlen++;
            } else {
                if (nlen > olen) {
                    ostart = nstart;
                    olen = nlen;
                }
                nstart = i;
                nlen = 0;
            }
        }
        if (olen > nlen) {
            return str.substring(ostart, (ostart + 1) + olen);
        } else {
            return str.substring(nstart, (nstart + 1) + nlen);
        }
    }
    /**
     * 找出最长数字串
     * @param str
     */
    public static String longestNum(String str) {
        int len = str.length();
        int start = 0,end = 0,max = 0;
        int numlen;
        for (int i = 0; i < len; i++) {
            int j = i;//指针
            numlen = getLen(str,j,j);
            if (numlen != 0) {
                j += numlen - 1;
            }
            if (i != j) {//下一个不是数字
                if (max < numlen) {
                    max = numlen;
                    start = i;
                    end = j;
                }
            }
            i = j;
        }
        return str.substring(start,end + 1);
    }

    /**
     * 连续数字的长度
     * @param s
     * @param left
     * @param right
     * @return
     */
    public static int getLen(String s, int left, int right) {
        while (right + 1 < s.length()) {
            if (Character.isDigit(s.charAt(right)) && Character.isDigit(s.charAt(right + 1))){
                right++;
            } else {
                break;
            }
        }
        if (left == right) { //不是连续数字
            return 0;
        }
        return right + 1 - left;
    }
}
