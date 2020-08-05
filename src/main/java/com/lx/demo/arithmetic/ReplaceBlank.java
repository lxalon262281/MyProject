package com.lx.demo.arithmetic;


/**
 * 替换空格算法
 */
public class ReplaceBlank {

    public static void main(String[] args) {
        String str = "we are coder";

        ReplaceBlank replaceBlank = new ReplaceBlank();
        System.out.println(replaceBlank.solution2(str));
    }

    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
     * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     */
    public String solution1(String str) {
        int len = str.length();

        StringBuffer result = new StringBuffer();

        for (int i = 0 ; i < len; i++) {
            char c = str.charAt(i);

            if (String.valueOf(c).equals(" ")) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 第二种方法：利用API替换掉所用空格，一行代码解决问题
     */
    public String solution2(String str) {
       String result = str.toString().replaceAll("\\s","%20");
       return result;
    }
}
