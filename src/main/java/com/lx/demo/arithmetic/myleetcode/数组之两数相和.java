package com.lx.demo.arithmetic.myleetcode;

import java.util.HashMap;

import static com.lx.demo.Go.i;

public class 数组之两数相和 {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        twoSum(arr,9);
    }
    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            temp = target - nums[i];

            if(!map.containsKey(temp)) {
                map.put(nums[i],i);
            } else {
                result[0] = map.get(temp);
                result[1] = i;
            }
        }

        return result;
    }
}
