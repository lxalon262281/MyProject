package com.lx.demo.arithmetic.myleetcode;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class 字符串之反转单词 {
    public static void main(String[] args) {
        System.out.println(reverseStr("I am a student"));
    }
    public static String reverseStr(String s) {
        if (s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        reverse(chars,start,end);
        start = end = 0;
        while (start < chars.length) {
            if (chars[start] == ' ') {
                start++;
                end++;
            } else if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, -- end);
                start = end + 1;
                end++;
            } else {
                end++;
            }
        }
        return new String(chars);
    }

    public static void reverse(char[] chars,int start,int end) {
        if (chars == null || start < 0 || end > chars.length - 1) {
            return;
        }

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
}
