package com.lx.demo.arithmetic.myleetcode;

import java.util.Arrays;
import java.util.EmptyStackException;

public class 数组之用数组实现栈的功能 {
    static int[] data = new int[10];
    static int size = 0;
    public static void main(String[] args) {

    }

    public static int pop() {
        int num = peek();
        size--;
        return num;

    }

    public static void push(int num) {
        if (size > data.length) {
            data = Arrays.copyOf(data,data.length * 2);
        } else {
            data[size++] = num;
        }
    }

    public static int peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public static void empty() {
        size = 0;
    }

    //返回对象在堆栈中的位置，以 1 为基数

    public int research(int num) {

        //顺着放倒着拿（FILO/LIFO）
        for (int i = size-1; i >=0; i--) {
            if (num == data[i] || num != 0 && data[i] == num) {
                return size-i;   				}
        }
        return -1;    //返回栈中不存在该元素
    }


}
