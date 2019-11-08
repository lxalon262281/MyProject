package com.lx.demo.thread;

public class Count implements Runnable {
    private static int sCount = 0;

    public static int getCount() {
        return sCount;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10000; i++) {

            sCount++;
            System.out.println(Thread.currentThread().getName() + " ---" + getCount());
        }
    }
}