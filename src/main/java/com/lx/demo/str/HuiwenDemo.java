package com.lx.demo.str;

/**
 * 判断整数（字符串是否是回文数）
 */
public class HuiwenDemo {
    public static void main(String[] args) {
        Integer num = 1210;
        Integer temp = num;
        System.out.println(num);
        Integer a,n = 0;
        while (num > 0) {
            a = num % 10;
            n = n * 10 + a;
            num = num / 10;
        }
        System.out.println(n);
        checkString("10");

    }

    /**
     * 判断回文串
     * 思路：先把字符串反转，然后再挨个比较
     * @param s
     */
    public static void checkString(String s) {
        int x = 10;
        StringBuffer sb = new StringBuffer(x + "");
        sb.reverse();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) ==sb.charAt(i)) {
                count++;
            }
        }
        if (count == s.length()) {
            System.out.println("y");
            //return true;
            //是回文数
        } else {
            System.out.println("n");
           // return false;
            //不是回文数
        }

    }
}
