package com.lx.demo.arithmetic.myleetcode;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        int[] nums = {1,2,5,3,2,3,6,4,1};
//        int[] nums = {4,3,2,7,8,2,3,1};
//        for(int i = 0; i < nums.length;){
//            if(nums[i] != nums[nums[i] - 1])
//                swap(nums,i,nums[i]-1);
//            else
//                i++;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] != i+1)
//                list.add(nums[i]);
//        }
//        System.out.println(list.toArray());
        test("jhdsyuwr jkdfiuesdk; iuibdsdch jlkdwekew ");

    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void test(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        while (i < len) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i++],1);
            } else {
                int count = map.get(arr[i]);
                count = count + 1;map.put(arr[i++],count);
            }
        }

        Set<Map.Entry<Character, Integer>> entry = map.entrySet();
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(entry);

        Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });


        for (Map.Entry<Character, Integer> e : list) {
            System.out.println(e.getKey() + "   " + e.getValue());
        }

    }
}
