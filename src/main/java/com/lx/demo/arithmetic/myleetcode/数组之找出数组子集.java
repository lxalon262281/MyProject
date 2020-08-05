package com.lx.demo.arithmetic.myleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数组之找出数组子集 {
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1,8};
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(arr);
        solution(arr,list,result,0);
        for(List<Integer> tem:result){
            System.out.println(Arrays.toString(tem.toArray()));
        }
    }

    public static List<List<Integer>> solution(int[] arr,List<Integer> list,
                                               List<List<Integer>> result, int k) {
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
