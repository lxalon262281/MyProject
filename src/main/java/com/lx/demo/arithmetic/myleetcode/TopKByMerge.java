package com.lx.demo.arithmetic.myleetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKByMerge {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8, 4, 2, 5, 66, 4, 4, 6, 3, 5, 6, 74, 56, 5, 7, 5, 7, 6, 4, 3, 4, 5, 4, 3};
    }

    /**
     * PriorityQueue可以实现大小堆，时间复杂度为时间复杂度为O(nlogm)，
     * 这样在n较大情况下，是优于nlogn的时间复杂度的
     * @param nums
     * @param k
     * @return
     */
    public static ArrayList<Integer> getTopK(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums.length < k) {
            return res;
        }

        PriorityQueue<Integer> pr = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pr.add(nums[i]);
        }

        for (int j = 0; j < k; j++) {
            res.add(pr.remove());
        }

        return res;
    }

}
