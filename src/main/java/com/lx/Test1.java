package com.lx;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test1{

    public static void main(String[] args) {
        String s = "";

       try {
           String s1 = s.replace("\n",",").toString();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date d = new Date();
           Date d2 = sdf.parse("2018-09-10 10:58:19");
           System.out.println("d2 :" + d2.getTime());

           System.out.println(System.currentTimeMillis());
       } catch (Exception e) {

       }
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.next();
//            System.out.println(findMaxString(str));
//        }
    }

    public static int findMaxString(String inString){
        int nowLength = 0;
        StringBuffer nowSb = null;

        int maxStringLength = 0;
        StringBuffer maxsb = null;

        for (int i =0;i <inString.length();i++){
            if (inString.charAt(i) >= 48 && inString.charAt(i)<=57){//char为字符型，实际上也是一种整数类型，16位无符号整数类型。因此可以直接与数值比较大小，加减乘除
                if (nowLength == 0){//需要判断nowStringLength是否等于0，如果等于0，说明nowStringBuffer为null，需要初始化
                    nowSb = new StringBuffer(inString.valueOf(inString.charAt(i)));
                    nowLength++;
                } else {//nowStringLength不等于0，说明此时nowStringBuffer不为null，无需初始化，直接append(char)即可继续添加连续的数字
                    nowSb.append(inString.charAt(i));
                    nowLength++;//StringLength作为标志位，保持与StringBuffer的同步变化
                }
                if (nowLength>maxStringLength){//每处理一个字符，将历史最长值与当前连续最长值进行比较
                    maxStringLength = nowLength;
                    maxsb = nowSb;
                }
            } else {
                nowLength = 0;
                nowSb = null;
            }
        }
        System.out.println(maxsb);
        return maxStringLength;
    }


}
