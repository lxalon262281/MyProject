package com.lx.demo.arithmetic.myleetcode;

import java.util.Stack;

public class 栈之用两个栈实现队列 {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Integer num1 = 1;
        Integer num2 = 2;
        Integer num3 = 3;
        Integer num4 = 4;
        Integer num5 = 5;
        Integer num6 = 6;

        append(num1);
        append(num2);
        append(num3);
        append(num4);

        System.out.print(delete() + " ");
        System.out.print(delete() + " ");

        append(num5);
        System.out.print(delete() + " ");
        append(num6);

        System.out.print(delete() + " ");
        System.out.print(delete() + " ");
        System.out.print(delete() + " ");

    }

    public static void append(Integer element) {
        stack1.push(element);
    }

    public static Integer delete() {
        while (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }


}
