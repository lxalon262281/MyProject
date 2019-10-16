package com.lx.thread;

public class LockTest {
    public static void main(String[] args) {
        Count count = new Count();
        Thread t1 = new Thread(count);
        Thread t2 = new Thread(count);
        t1.start();
        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        } catch (Exception e) {
//            e.getMessage();
//        }
        System.out.println(Count.getCount());
    }
}
