package com.lx.str;

/**
 * 判断两个字符串大小
 */
public class CompareToDemo {
    public static void main(String[] args) {
        String s1 = "qwgrty";
        String s2 = "qwfdey";
        System.out.println(s1.compareTo(s2));

        System.out.println(compare(s1,s2));
    }


    public static int compare(String s1,String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int min = Math.min(len1,len2);

        char[] v1 = s1.toCharArray();
        char[] v2 = s2.toCharArray();
        int k = 0;
        while (k < min) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;

    }
}
