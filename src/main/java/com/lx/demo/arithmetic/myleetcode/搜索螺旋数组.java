package com.lx.demo.arithmetic.myleetcode;

/**
 * @Auther: allanyang
 * @Date: 2019/9/29 11:14
 * @Description:
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class 搜索螺旋数组 {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        search(arr,5);
    }

    public static int search(int arr[], int target) {
        if (arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            int min = left + (right - left) / 2;
            if (arr[min] ==  target) {
                return min;
            } else if (arr[min] < arr[right]) {
                if (arr[min] < target && arr[right] > target) {
                    left = min + 1;
                } else {
                    right = min - 1;
                }
            } else {
                if (arr[left] <= target && arr[min] > target) {
                    right = min - 1;
                } else {
                    left = min + 1;
                }
            }
        }
        return -1;

    }
}
