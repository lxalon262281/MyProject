package com.lx.demo.thread;

import java.util.concurrent.Semaphore;

public class SemaphoreTestMain {
    static Semaphore sSemaphore = new Semaphore(2);

    public static void main(String[] args) {

        final SemaphoreTestMain semaphoreTestMain = new SemaphoreTestMain();
        for (int i = 0; i < 10; i++) {
            Thread myThread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        semaphoreTestMain.test();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            myThread.setName("threat index:" + i);
            myThread.start();

        }

    }


    public void test() throws InterruptedException {
        System.out.println("获取当前允许进入方法的线程数量=" + sSemaphore.availablePermits());
        sSemaphore.acquire();
        System.out.println(Thread.currentThread().getName() + "--in");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "--out");
        sSemaphore.release();

    }
}