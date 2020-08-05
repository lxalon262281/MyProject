package com.lx.demo.arithmetic.myleetcode;


import java.util.Scanner;

/**
 * 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。
 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如285经过一次变换后转化成2*8*5=80.
 问题是，要做多少次变换，使得这个数变成个位数。
 输入描述
 输入一个整数。小于等于2,000,000,000。
 输出描述
 输出一个整数，表示变换次数。

 */
public class 变换次数 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        String s = String.valueOf(value);
        int len = s.toCharArray().length;
        int chengji = 0;
        int count = 0;
        //2,000,000,000
        while (value / 10 != 0) {
            int gewei = value % 10;
            int shiwei = ((value - gewei) / 10) % 10;
            int baiwei = value / 100;
            chengji = gewei * shiwei * baiwei;
            value = chengji;
            count++;
        }
        System.out.println(count);
    }

    public static void changeCount(int num) {
        int count = 0;
        int gewei = 0;
        int shiwei = 0;
        int baiwei = 0;

        int product = 0;
        while (num / 10 != 0) {
            gewei = num % 10;
            shiwei = ((num - gewei) / 10) % 10;
            baiwei = num / 100;
            product = baiwei * shiwei * gewei;
            num = product;
            count++;
        }
    }
}