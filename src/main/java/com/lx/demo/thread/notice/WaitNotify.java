package com.lx.demo.thread.notice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static Boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(),"waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThrea = new Thread(new Notify(),"waitThread");
        notifyThrea.start();

    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    while (flag) {
                        System.out.println(Thread.currentThread().getName() + " flag is true,wait @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName() + " flag is false,running @"
                        + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " hold lock,notify @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.notify();
                        flag = false;
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " hold lock agin,sleep @"
                                + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
                System.out.println("test");
            }
        }
    }
}
