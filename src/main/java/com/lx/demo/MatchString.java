package com.lx.demo;

import java.util.Stack;

/**
 * 栈的先入后出，非常适合作为括号匹配的对象 思路：将所有的左括号类型入栈，出现一个匹配的右括号即出栈
 * 如果最后栈为空则完全匹配；如果最后栈非空则不匹配
 */
public class MatchString {

    public static boolean isMatchStr(String s){
        if(s==null || s.length()<1) {
            return false;
        }
        Stack<Character> stack=new Stack<Character>();
        char c;
        boolean flag=true;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
//              入栈规则
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
                cnt++;
                continue;
            }
//              过滤非括号的无关字符串
            if(c!='(' && c!='[' && c!='{' && c!=')' && c!=']' && c!='}') continue;
//              出栈规则
            if(stack.isEmpty()||!isMatch(c,stack.peek())) return false;
            if (!stack.isEmpty() && isMatch(c, stack.peek())) {
                stack.pop();
                cnt++;
                continue;
            }

        }
        if(!stack.isEmpty()) return false;
        return flag;
    }

    private static boolean isMatch(char right, char left) {
        if(right==')'){
            return left=='(';
        }
        if(right==']'){
            return left=='[';
        }
        if(right=='}'){
            return left=='{';
        }
        return false;
    }

    public static void main(String[] args) {
        String s1="({{123}})";
        String s2="}}}}}{{{{";
        String s3="((111111({{}}})))";
        System.out.println(isMatchStr(s1));
        System.out.println(isMatchStr(s2));
        System.out.println(isMatchStr(s3));

    }
}