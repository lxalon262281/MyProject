package com.lx.demo.arithmetic.bat;

/**
 * @Auther: allanyang
 * @Date: 2020/1/12 14:44
 * @Description:
 **/
public class 字符串 {

    /**
     * 字符串相关概念
     *
     * 1.回文
     * 2.字串（连续）
     * 3.子序列（不连续）
     * 4.前缀树（Trie树）
     * 5.后缀树和后缀数组
     * 6.匹配
     * 7.字典序
     *
     *
     * 常见题型：
     * 1.判断规则
     * 1.1 判断字符串是否符合整形规则
     * 1.2 判断字符串是否符合浮点数规则
     * 1.3 判断字符串是否符合会问字符串规则
     * ...
     * 2.数字运算
     * int和long类型表达证书范围有限，所以经常用字符串实现大整数
     * 3.与数组操作有关的类型
     * 3.1数组有关的调整，排序等操作需要掌握
     * 3.2快速排序的划分过程需要掌握和改写
     * 4.字符计数
     * 4.1哈希表
     * 4.2固定长度数组
     * 4.3滑动窗口问题，寻找无重复字串问题，计算变位词问题。
     * 5.动态规划
     * 5.1最长公共子串
     * 5.2最长公共子序列
     * 5.3最长回文子串
     * 5.4最长回文子序列
     * 6.搜索类型
     * 6.1宽度优先搜索
     * 6.2深度优先搜索
     * 7.
     */

    // 1.给定彼此独立的两颗树头结点t1和t2，判断t1中是否有与t2树拓扑结构的完全相投的字数
    /**
     * 先将树序列化，然后进行kmp匹配
     */

    // 2.给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数一样
    // 那么str1和str2互为变形此，请实现函数判断是否两个字符串互为变形词。
    /**
     * 利用hash表
     */

    // 3.如果一个字符串str，把字符串str前面任意的部分挪到后面去形成的字符串叫str的旋转此。
    // 比如str="1234",str的旋转词有"1234","2341","3412","4123".
    // 给定两个字符串a和b，判断a和b是否互为旋转词。
    /**
     * 最有时间复杂度O（n）
     * 1.判断str1和str2长度是否相等
     * 2.如果长度想到等，生成str1+str1的大数组
     * 3.用kmp判断大字符串是否包含str2
     */

    // 4.给定一个字符串str，请在单词键做逆序调整。
    // “pig loves dog” 逆序 “dog loves pig”
    /**
     * 1.先将句子整体逆序
     * 2.将局部逆序
     */

    // 5.给定一个字符串str和一个整数i，i代表str中的位置，将str【0.。i】移到右侧，将str【i+1,n-1】移到左侧
    // str=“ABCDE” i=2, --> "DEABC"  要求时间复杂度O（N），空间复杂度O（1）
    /**
     * 1.先把【0..i】做逆序调整
     * 2.把【i+1~n-1】做逆序调整
     * 3.整体逆序
     */

    // 6.给定一个字符串类型的数组strs，请找到一种拼接顺序，使得将所有字符串拼接起来组成的大字符串是所有可能性中字典顺序最小的，并返回这个大字符串。
    /**
     * 时间复杂度O（nlgn）
     * 对str1+str2按照字典序排序
     */

    // 7.给定一个字符串str，将其中所有空格字符替换成“%20    ”，假设str后面有足够的空间
    /**
     * 从后面往前拷贝
     */

    // 8.给定一个字符串str，判断是不是整体有效的括号字符串
    /**
     * 1.栈 时间O（n），空间O（n）
     *
     * 2.时间O（n），空间O（1）
     * 2.1用一个整形变量num记录‘（’和‘）’出现的次数
     * 2.2遍历如果遇到‘(’,则num++，反之zenum--
     * 2.3如果num<0返回false
     * 2.4如果最后num！=0，返回false
     * 2.5其余返回true
     */

    // 9.给定一个字符串str，返回str的最长无重复子串长度
    // str="abcd" -> 4
    // str="abcb" -> 3 "abc"
    /**
     * 时间复杂度O（n），空间复杂度O（n）
     * 求出一str中每个字符结尾的情况下，最长无重复字符字串的长度，并在其中找到最大值返回。
     * 利用hashmap和pre来进行记录
     */
}
