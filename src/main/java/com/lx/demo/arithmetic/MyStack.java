package com.lx.demo.arithmetic;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 括号匹配问题
 */
public class MyStack {
    public static void main(String[] args) {
//        String s = "()()[[";
//        System.out.print(solution(s));
//        Scanner in = new Scanner(System.in);
//        int num = Integer.parseInt(in.next());
//        List<String> list = new ArrayList<>();
//
//        int i = 0;
//        while (i < num && in.hasNext()) {
//            list.add(in.next());
//            i++;
//        }
//        int result = 0;
//        for (String str : list){
//            if (solution(str)) {
//                result += 1;
//            }
//        }
        System.out.println(solution2("{{(]])})"));




//        // TODO Auto-generated method stub
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            Stack<Character> stack = new Stack<Character>();
//            String s = in.nextLine();
//            int flag = 0;
//            //stack.push('#');
//            String s1 = "([{";
//            String s2 = ")]}";
//            char[] chars = s.toCharArray();
//            if (chars.length % 2 == 0) {//奇数肯定不匹配
//                for (int i = 0; i < chars.length; i++) {
//                    int n1 = s1.indexOf((chars[i])) + 1;//是左括号直接进栈
//                    if (n1 != 0) {
//                        stack.push(chars[i]);
//                    }
//                    int n2 = s2.indexOf((chars[i])) + 1;//如果是右括号，弹出栈顶，进行匹配，成功flag=1，不成功flag=0退出
//                    if (n2 != 0) {
//                        char c = stack.pop();
//                        if (Match(c, chars[i])) {
//                            flag = 1;
//                        } else {
//                            flag = 0;
//                            break;
//                        }
//                    }
//                }
//            }
//
//            if (flag == 1) {
//                System.out.println("YES");
//            } else
//                System.out.println("NO");
//        }

    }


    private static boolean Match(char c, char d) {
        // TODO Auto-generated method stub
        if (c == '(' && d == ')') {
            return true;
        }
        if (c == '[' && d == ']') {
            return true;
        }
        if (c == '{' && d == '}') {
            return true;
        }
        return false;
    }


    public static boolean solution(String s) {
        if (s.equals("")) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) ==')' && stack.pop() != '(') {
                    return false;
                }
                if (s.charAt(i) =='}' && stack.pop() != '{') {
                    return false;
                }
                if (s.charAt(i) ==']' && stack.pop() != '[') {
                    return false;
                }
            }
        }

        System.out.println(s + "-------" + stack.empty());
        return stack.empty();
    }


    public static boolean solution2(String s) {
//        s = "3+2*{1+2*[-4/(8-6)+7]}";
        s = "3+2*(1+2)";
        int count = 0;
        int temp;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ')' && s.charAt(i) != ']' && s.charAt(i) != '}') {
                stack.push(s.charAt(i));
            }

            if (!stack.isEmpty() && s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                while (!stack.isEmpty() && (temp = stack.pop()) != '(') {
                    stack2.push((char)temp);
                }
                float result = calculate(stack2);
                stack.push((char) result);

            }

        }
        System.out.println(count);
        return false;
    }

    public static float calculate(Stack<Character> stack) {
        Integer result = null;

        while (!stack.isEmpty()) {
            Character c = stack.pop();
            if (!Character.isDigit(c) && result != null) {
                if (c.equals('+')) {
                    result = result + Integer.parseInt(stack.pop().toString());
                }
                if (c.equals('-')) {
                    result = result - Integer.parseInt(stack.pop().toString());
                }
                if (c.equals('*')) {
                    result = result * Integer.parseInt(stack.pop().toString());
                }
                if (c.equals('/')) {
                    result = result + Integer.parseInt(stack.pop().toString());
                }
                if (c.equals('%')) {
                    result = result % Integer.parseInt(stack.pop().toString());
                }

            } else {
                result = Integer.parseInt(c.toString());
            }
        }

        return result;

    }

}
