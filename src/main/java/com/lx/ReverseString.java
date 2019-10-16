package com.lx;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 字符串倒转
 */
public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverse = new  ReverseString();
//        reverse.reverseString1("abcd efg   ijklmn ppp nmkl");
//        reverse.reverseString2("abcd efg   ijklmn ppp nmkl");
//        reverse.reverseString3("abcd efg   ijklmn ppp nmkl");
//        reverse.reverseString4("abcd efg   ijklmn ppp nmkl");
//        reverse.reverseString5("abcd efg   ijklmn ppp nmkl");
        reverse.countStr("woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun","java");

    }

    public void reverseString1(String str) {
        String s = new StringBuffer(str).reverse().toString();
        System.out.println("reverseString1:" + s);
    }

    public void reverseString2(String str) {
        String[] strlist = str.trim().split(" +");//split的参数是正则表达式
        //用StringBuffer的效率要比String高一些，这里用String也是可以的
        StringBuffer sb = new StringBuffer();

        for(int i = strlist.length-1; i>=0; i--){
            sb.append(strlist[i] + " ");
        }

        System.out.println("reverseString2:" + sb.toString().trim());
    }

    public void reverseString3(String str) {
        char[] array = str.toCharArray();
        int arraylen = array.length;
        String reverse = "";
        for (int i = arraylen -1; i >= 0; i--) {
            reverse += array[i];
        }
        System.out.println("reverseString3:" + reverse);
    }

    public void reverseString4(String str) {
        //利用栈:First In Last Out
        //java中不用手动销毁
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<Character>();

        //进栈
        for (int i = 0; i < str.length();i++) {
            stack.add(str.charAt(i));
        }

        //出栈
        for (int i = 0; i < str.length(); i++) {
            sb.append(stack.pop());
        }

        System.out.println("reverseString4:" + sb.toString());
    }

    public void reverseString5(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
//        System.out.println("reverseString4:" + String.join("",words));
    }

    public void countStr(String content,String minstr) {
        int count = 0;
        int index = 0;
        while ((index = content.indexOf(minstr)) != -1) {
            count++;
            content = content.substring(index + minstr.length());
        }
        System.out.println(count);
    }

}
