package com.lx.demo.arithmetic.myleetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 示例:
 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 https://blog.csdn.net/memory_cood/article/details/88414601
 */
public class 动态规划之最大子序和 {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        solution(arr);
    }
    public static int maxSubArray(int[] nums) {
        int dp[]=new int[nums.length+1];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]>dp[k])k=i;
        }
        System.out.println(k + " ----- " + dp[k]);
        return dp[k];
    }

    public static int solution(int[] arr) {
        //d 用来保存最大连续子数组的值
        int[] d = new int[arr.length];
        if (arr.length == 0) {
            return 0;
        }

        int max = arr[0];
        d[0] = max;
        for (int i = 1; i < arr.length; i++) {
            if (d[i - 1] < 0) {
                d[i] = arr[i];
            } else {
                d[i] = arr[i] + d[i - 1];
            }

            max = Math.max(d[i],max);
        }

        System.out.println(max);

        return 0;

    }

}
