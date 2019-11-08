package com.lx.demo;

import java.util.Arrays;

public class StringArraySort {

    public static void main(String[] args) {
        String []str = {"abc","bca","cab","cba","aaa","111","232","112","ABC"};

        str = arraySort2(str);

        for(int i=0;i<str.length;i++){
            System.out.println(str[i]);
        }
    }

    //Arrays是java.util包中的，使用快排实现的
    public static String[] arraySort(String[] input) {
        Arrays.sort(input);
        return input;
    }

    public static String[] arraySort2(String[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j].compareTo(input[j + 1]) > 0) {
                    String temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        return input;
    }
}
