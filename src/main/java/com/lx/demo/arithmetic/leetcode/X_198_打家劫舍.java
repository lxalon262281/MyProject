package com.lx.demo.arithmetic.leetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/4 20:11
 * @Description:
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class X_198_打家劫舍 {

    public int rob(int[] nums) {
        if (nums.length <= 1) {
            return nums.length == 0 ? 0 : nums[0];
        }

        int curMax = nums[0];
        int preMax = 0;

        for (int i = 1;i < nums.length;i++) {
            int tmp = curMax;
            curMax = Math.max(tmp, preMax + nums[i]);
            preMax = tmp;
        }

        return Math.max(curMax, preMax);
    }


    /**
     * 更简洁的写法
     */
    public int rob1(int[] nums) {
        int pre1 = 0;
        int pre2 = 0;

        for (int i = 0;i < nums.length;i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }

    public static void main(String[] args) {
        X_198_打家劫舍 s = new X_198_打家劫舍();
        s.rob1(new int[]{2,1,1,2});
    }
}