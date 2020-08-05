package com.lx.demo.thread;


/**
 * 两个线程交替打印奇偶数
 */





public class printSD {

    private static int count = 0;
    private static Object lock = new Object();


    public static void main(String[] args) throws Exception {


        Thread even = new Thread(()->{
            while (count < 100) {
                synchronized (lock) {
                    // 只处理偶数
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        },"奇数");

        Thread odd = new Thread(()->{
            while (count < 100) {
                synchronized (lock) {
                    // 只处理偶数
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + count++);
                    }
                }
            }
        },"偶数");

        even.start();
        odd.start();

    }
}
