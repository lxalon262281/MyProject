package com.lx.demo.arithmetic.myleetcode;

/**
 * 优秀解法
 * https://blog.csdn.net/weixin_42047723/article/details/93721826
 */
public class 查找之找出目标值在数组中的起始位置 {
    /**
     * 思路：二分法查找然后往后遍历确定长度
     */

    public  int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int middle = (l + r) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return -1;
    }

    public  int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };
        if (nums == null || nums.length == 0) {
            return arr;
        }
        int index = binarySearch(nums, target);
        if (index == -1) {
            return arr;
        }
        int l = index - 1;
        while (l >= 0 && nums[l] == target) {
            --l;
        }
        arr[0] = l + 1;
        int r = index + 1;
        while (r < nums.length && nums[r] == target) {
            ++r;
        }
        arr[1] = r - 1;

        return arr;
    }

}
