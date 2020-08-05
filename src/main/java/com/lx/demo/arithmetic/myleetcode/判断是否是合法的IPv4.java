package com.lx.demo.arithmetic.myleetcode;

public class 判断是否是合法的IPv4 {

    public static boolean isIPFour(String ip) {
        int iPSize = ip.length(), index = 0, okStep = 0;//用于记录合法的段

        //扫描字符串，需要寻找到连续的4个合法的段
        while (index < iPSize) {
            String tempStr = "";

            while (index < iPSize && ip.charAt(index) != '.') {
                //判断是否是数字
                if (Character.isDigit(ip.charAt(index))){
                    tempStr += ip.charAt(index++);
                } else{
                    return false;
                }
            }

            //是否为空，长度大于1时，起始字符是否是'0'形如‘023’，或者是字符长度大于3，超过'255'
            if (tempStr.length() == 0 || (tempStr.length() > 1 && tempStr.charAt(0) == '0')
                    || tempStr.length() > 3 || Integer.valueOf(tempStr) > 255){
                return false;
            }
            okStep += 1;//合法的段自增
            index += 1;

        }
        return ip.charAt(index - 1) != '.' && okStep == 4;//IPv4有四个段
    }
}
