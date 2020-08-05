package com.lx.demo.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组的所有子集
 */
public class Group {

    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> printlist = new ArrayList<>();

        Arrays.sort(arr);

        group(arr,list,printlist,0);

        for(List<Integer>tem:printlist){
            System.out.println(Arrays.toString(tem.toArray()));
        }
    }
    static List<List<Integer>>group(int[]arr,List<Integer> list,List<List<Integer>> printlist,int index){

        printlist.add(new ArrayList<>(list));

        if(list.size() == arr.length) {
            return printlist;
        }

        for(int i = index; i <  arr.length; i++){

            list.add(arr[i]);

            group(arr,list,printlist,i + 1);

            list.remove(list.size() - 1);
        }
        return printlist;
    }
}
