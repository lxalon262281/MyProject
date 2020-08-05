package com.lx.demo.arithmetic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证回文串(回文数)
 *
 */
public class CheckPSDemo {
    public static void main(String[] args) {
        System.out.println(solution2("A man, a plan, a canal: Panama"));
    }

    public static boolean solution(String str) {
        if (str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }

        str = str.toLowerCase();

        StringBuffer sb = new StringBuffer(str);
        sb.reverse();

        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
             if (str.charAt(i) == sb.charAt(i)) {
                 count++;
             }
        }

        if (count == len) {
            return true;
        } else {
            return false;
        }
    }

    public static String filterStr(String str) {
        String regEx = "[^0-9a-zA-Z]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        //替换与模式匹配的所有字符（即非数字的字符将被""替换）
        String result =  m.replaceAll("").trim();
        System.out.println(result);
        return result;
    }

    public static boolean solution2(String str) {
        if (str.isEmpty()) {
            return true;
        }
        if (str.length() == 0) {
            return false;
        }

        str = str.toLowerCase();
        int len = str.length();
        int l = 0;
        int r = len -1;

        for (int i = 0; i < len; i ++) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
            } else {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return true;
    }
}
