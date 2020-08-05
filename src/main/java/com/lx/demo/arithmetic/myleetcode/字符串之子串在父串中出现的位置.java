package com.lx.demo.arithmetic.myleetcode;

public class 字符串之子串在父串中出现的位置 {
    public static void main(String[] args) {
        String str1 = "lizhongyiazhongyi";
        String str2 = "azhong";

        System.out.println(findFirstPositionOfSubString2(str1, str2));
    }

    /**
     * 思路：每次从父串截取子串长度的串，和子串比较是否相等，不相等则父串向右便宜点一位再截取
     * @param s1
     * @param s2
     * @return
     */
    public static int findFirstPositionOfSubString(String s1,String s2) {
        int s2Len = s2.length();
        int offset = 0;
        String substr = null;

        if (s1.length() == 0 || s2.length() == 0 || s1.length() < s2Len ) {
            return -1;
        } else {
            while (offset < (s1.length() - s2Len)) {
                substr = String.copyValueOf(s1.toCharArray(),offset,s2Len);
                if (substr.equals(s2)) {
                    return offset;
                } else {
                    offset++;
                }
            }

        }

        return -1;
    }

    public static int findFirstPositionOfSubString2(String s1,String s2) {
        int s2len = s2.length();
        int s1len = s1.length();
        int offset = 0;

        if (s2len == 0 || s1len == 0 || s1.length() < s2len ) {
            return -1;
        } else {
            while (offset < s1len - s2len) {
                String str = String.copyValueOf(s1.toCharArray(),offset,s2len);

                if (str.equals(s2)) {
                    return offset;
                } else {
                    offset++;
                }
            }
        }

        return -1;
    }
}
