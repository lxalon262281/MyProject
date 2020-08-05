package com.lx.demo.str;

/**
 * 查找最长回文串
 */
public class Findhuiwen {
    /**************************
     * 求解字符串的最长回文串----暴力法 O(n^3)
     * 通过两层循环找出字符串的所有子串  对每一个子串进行判断
     * 将是回文串的子串储存  当有新的回文串时，比较记录中的回文串和当前回文串的长度
     * 用较长的串替换当前串  如果两串长度相同，保留旧的
     * PS：如果想保存所有的回文串 可以修改记录回文串的结构为String数组（链表、hash表都可以）
     * @return 返回字符串中的最长回文串
     */

    public static void main(String[] args) {

        System.out.println(longesthuiwen("asdfghgfdsaq11q11"));
    }


    public static String longestPlalindrome(String original) {
        //非空判断
        if((original==null)||original.length()==0) {
            return null;
        }
        char[] oriArray = original.toCharArray();
        int first = 0;
        int end = 0;//当前字符串中回文串的始末位置 包含末位置
        for(int i = 0;i < oriArray.length - 1; i++){//两次循环 查找字符串的所有子串
            for(int j = i;j < oriArray.length; j++) {
                //判断子串是否为回文串
                int left = i,right = j;//记录左侧右侧的位置
                while(left < right){//左侧下标小于右侧下标时 比较未完成
                    if(oriArray[left] != oriArray[right])
                        break;//如果出现对称位置不相等元素  则不是回文串跳出循环
                    //判断下一对称位置
                    left++;
                    right--;

                }
                if(left >= right){//是否比较完成 是字符串是否为回文串的判断条件
                    if(j - i > end - first){//查找到回文串 且长度大于当前存储的回文串长度
                        //替换当前回文串
                        first = i;
                        end = j;
                    }
                }
            }
        }
        //查找结束  将数组转化为字符串返回
        return String.valueOf(oriArray, first, end + 1);
    }

    /**
     * 中心查找法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        int num1, num2, len;
        for (int i = 0; i < s.length(); i++) {
            num1 = getMaxLength(s, i, i);
            num2 = getMaxLength(s, i, i + 1);
            len = Math.max(num1, num2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int getMaxLength(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longesthuiwen(String s){
        if(s.length() == 0) {
            return null;
        }
        int max = 0;
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < s.length(); i++ ) {
            int len1 = gethuiwenlength(s,i,i);
            int len2 = gethuiwenlength(s,i,i + 1 );
            max = Math.max(len1,len2);
            if(max > end - start) {
                start = i - (max -1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start,end + 1);
    }

    public static int gethuiwenlength(String s, int left, int right) {
        int slen = s.length();
        while(right < slen && left >= 0 && s.charAt(left) == s.charAt(right)) {
            right++;
            left--;
        }
        int result = right - left - 1;
        return result;
    }

}
