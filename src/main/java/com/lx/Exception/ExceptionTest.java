package com.lx.Exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            test3();
        } catch (Exception e) {
            System.out.println("error1");
            e.getMessage();
        }
    }

    public static void test1() throws Exception{
        int a = 2;
        int b = 0;
        int c = a / b;
        System.out.println(c);
    }

    public static void test2() throws Exception {
        try {
            int a = 2;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (Exception e) {
            //System.out.println("error2");
            System.out.println( e.getMessage());
        }
    }

    public static void test3(){
            int a = 2;
            int b = 0;
            int c = a / b;
            //throw new Exception("by zore");
            //System.out.println(c);
    }
}
