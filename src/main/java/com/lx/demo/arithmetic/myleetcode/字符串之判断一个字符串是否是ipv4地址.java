package com.lx.demo.arithmetic.myleetcode;

/**
 * /**

 1.判断字符串是否形如“192.168.1.1”

 2.字符串两端含有空格视为合法ip，形如“    192.168.1.1    ”

 3.字符串中间含有空格视为非法ip，形如“192.168. 1.2”

 4.字符串0开头视为不合法ip，形如192.168.01.1

 5.字符串0.0.0.0视为合法ip
 */

public class 字符串之判断一个字符串是否是ipv4地址 {
    public static void main(String[] args) {
        System.out.println(isipv4("192.168.1.300"));
    }
    public static boolean isipv4(String ipv4){
        if(ipv4 == null || ipv4.length()==0){
            return false;//字符串为空或者空串
        }
        String[] parts=ipv4.split("\\.");//因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"
        if(parts.length!=4){
            return false;//分割开的数组根本就不是4个数字
        }
        for(int i = 0;i < parts.length; i++){
            try {
                int n = Integer.parseInt(parts[i]);

                if(n < 0 || n > 255){
                    return false;//数字不在正确范围内
                }
            } catch (NumberFormatException e) {
                return false;//转换数字不正确
            }
        }
        return true;
    }
}
