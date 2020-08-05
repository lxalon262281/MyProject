package com.lx.demo.str;

/**
 * 子串在父串中出现的位置
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String str1 = "lizhongyizhongyi";
        String str2 = "zhong";

        System.out.println(findFirstPositionOfSubString(str1, str2));
    }
    /**
     * 找到字符串str2在字符串str1中第一次出现的位置，找不到返回-1
     */
    public static int findFirstPositionOfSubString(String str1, String str2) {
        int offset = 0;
        String substr = null;

        if((str1 == null) || (str2 == null) || (str1.length() < str2.length())) {
            return -1;
        } else {
            while(offset <= (str1.length() - str2.length())) {
                substr = String.copyValueOf(str1.toCharArray(), offset, str2.length());
                if(substr.equals(str2)) {
                    return offset;
                }
                offset ++;
            }
            return -1;
        }
    }
}
