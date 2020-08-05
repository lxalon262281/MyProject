package com.lx.demo.arithmetic.myleetcode;

import org.apache.commons.lang.StringUtils;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 字符串之替换空格 {
    public static void main(String[] args) {
        update2("We Are Happy");
    }

    public static void update(String s) {
        String str = s.replaceAll(" ","%20");
        System.out.println(str);
    }
    public static void update2(String s) {
        if (s.length() == 0) return;
        int spaceCount = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        char[] charArray = new char[chars.length + spaceCount * 2];

        int index = charArray.length - 1;
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] == ' ') {
                charArray[index--] = '0';
                charArray[index--] = '2';
                charArray[index--] = '%';

                int flag = 1;
            } else {
                charArray[index--] = chars[j];
            }
        }

        System.out.println(charArray);

    }

}
