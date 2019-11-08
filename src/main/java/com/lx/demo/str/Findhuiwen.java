package com.lx.demo.str;

public class Findhuiwen {
    /**************************
     * 求解字符串的最长回文串----暴力法 O(n^3)
     * 通过两层循环找出字符串的所有子串  对每一个子串进行判断
     * 将是回文串的子串储存  当有新的回文串时，比较记录中的回文串和当前回文串的长度
     * 用较长的串替换当前串  如果两串长度相同，保留旧的
     * PS：如果想保存所有的回文串 可以修改记录回文串的结构为String数组（链表、hash表都可以）
     * @param str 要求解的字符串
     * @return 返回字符串中的最长回文串
     */
    public static String longestPlalindrome(String original) {
        //非空判断
        if((original==null)||original.length()==0) {
            return null;
        }
        char[] oriArray=original.toCharArray();
        int first=0;
        int end=0;//当前字符串中回文串的始末位置 包含末位置
        for(int i=0;i<oriArray.length-1;i++){//两次循环 查找字符串的所有子串
            for(int j=i;j<oriArray.length;j++) {
                //判断子串是否为回文串
                int left=i,right=j;//记录左侧右侧的位置
                while(left<right){//左侧下标小于右侧下标时 比较未完成
                    if(oriArray[left]!=oriArray[right])
                        break;//如果出现对称位置不相等元素  则不是回文串跳出循环
                    //判断下一对称位置
                    left++;
                    right--;

                }
                if(left>=right){//是否比较完成 是字符串是否为回文串的判断条件
                    if(j-i>end-first){//查找到回文串 且长度大于当前存储的回文串长度
                        //替换当前回文串
                        first=i;
                        end=j;
                    }
                }
            }
        }
        //查找结束  将数组转化为字符串返回
        return String.valueOf(oriArray, first, end+1);
    }

}
