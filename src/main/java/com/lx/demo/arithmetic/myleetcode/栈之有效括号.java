package com.lx.demo.arithmetic.myleetcode;

import java.util.Stack;

public class 栈之有效括号 {
    public static void main(String[] args) {
        System.out.println(solution("(())[][][{}"));
    }

    public static boolean solution(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (s.charAt(i) == ')' && stack.pop() != '(') {
                return false;
            }
            if (s.charAt(i) == ']' && stack.pop() != '[') {
                return false;
            }
            if (s.charAt(i) == '}' && stack.pop() != '{') {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
