package com.lx.demo.arithmetic.myleetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 找出最长重复连续字串
 * 例如：
 * 例如字符串 s =“abcdeabc”
 * abdcdyedhjhyed
 * 输出：abc
 */
public class 字符串之找出最长重复连续子串 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println(maxString("abcdeabc"));
        try {
            solution2();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    //保存最长公共子串
    static String result = "";

    /**
     * 解题思路
     * 保存s字符串的所有后缀
     * 对所有后缀进行排序（自然排序）
     * 比较排序后的相邻的后缀的最长公共子串（两个后缀从第一个字符开始的就相等得到公共子串），
     * 求出最长的公共子串**
     * @throws InterruptedException
     */
    public static void solution2() throws InterruptedException {
        String s = "abcdeabc";
        ArrayList<String> list = new ArrayList<String>();
        //得到字符串的所有后缀
        for(int i = s.length()-1;i >= 0;i--) {
            list.add(s.substring(i));
        }
        Collections.sort(list);
        int maxLen = 0;
        for(int i = 0;i < s.length() - 1;i++) {
            int len = getComlen(list.get(i),list.get(i+1));
            maxLen = Math.max(maxLen, len);
        }
        System.out.println(result+":"+maxLen);
    }
    //得到两个字符串最长公共长度
    public static int getComlen(String str1,String str2) {
        int i;
        for(i = 0;i < str1.length() && i < str2.length();i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        String temp = str1.substring(0,i);
        if(temp.length() > result.length()) result = temp;
        return i;
    }
}
