package com.lx.demo.arithmetic.myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 递归之找出数组的所有子集 {
    static List<List<Integer>> result;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        solution(arr,list,result,0);

        for(List<Integer>tem:result){
            System.out.println(Arrays.toString(tem.toArray()));
        }
    }

    public static List<List<Integer>> solution(int[] arr,List<Integer> list,List<List<Integer>> result,int k) {
        result.add(new ArrayList<>(list));

        if (list.size() == arr.length) {
            return result;
        }

        for (int i = k; i < arr.length; i++) {
            list.add(arr[i]);
            solution(arr,list,result,i + 1);
            list.remove(list.size() - 1);
        }

        return result;
    }

}
