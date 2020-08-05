package com.lx.demo.arithmetic.myleetcode;

import org.apache.commons.lang.StringUtils;

public class 字符串之k步长分组反转 {
    public static void main(String[] args) {
        reverseStr("hellolongxiao",4);

    }
    public static String reverseStr(String s,int k) {
        char[] chars = s.toCharArray();
        int strSize = s.length(), doubleK = 2 * k;
        //扫描字符串，步长为doubleK = 2 * k
        for (int index = 0; index < strSize; index += k){
            if ((strSize - index) < k){
                //如果剩余少于 k 个字符，则将剩余的所有全部反转。
                if (index != strSize - 1) {
                    reverseString(chars, index,strSize - 1);
                }

            } else{
                reverseString(chars, index,index + k - 1);
            }
        }
        System.out.println(chars);
        return s;
    }

    public static void reverseString(char[] s,int left,int right) {
        // 左右双指针
        // 交换元素的临时变量 temp
        char temp;
        while (left < right){
            temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
