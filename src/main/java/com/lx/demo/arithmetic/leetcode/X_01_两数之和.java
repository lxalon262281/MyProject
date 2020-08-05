package com.lx.demo.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allanyang
 * @Date: 2019/8/31 18:50
 * @Description: 类型题：两数之和（1），三数之和（15），四数之和（18）
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 **/
public class X_01_两数之和 {

    /**
     * 用一个map存储起来其中一个，然后遍历
     */
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0;i < nums.length;i++) {
//            int tmp = target - nums[i];
//            if (map.containsKey(tmp)) {
//                return new int[]{i, map.get(tmp)};
//            }
//            map.put(nums[i], i);
//        }
//
//        return null;
//    }
    public static int[] solution (int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];

            if (map.containsKey(n)) {
                return new int[]{i,map.get(n)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] num = {2,0,1,7,3,8,5,3};
        int target = 9;
        int[] result = solution(num,target);
        System.out.println("");
    }
}
