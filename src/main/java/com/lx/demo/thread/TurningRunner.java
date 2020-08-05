package com.lx.demo.thread;

/**
 * 交替打印
 */
public class TurningRunner implements Runnable {
    private static int count = 0;
    private static Object lock = new Object();
    @Override
    public void run() {
        while (count <=100) {
            synchronized (lock) {
                // 拿到锁就打印
                System.out.println(Thread.currentThread().getName() + ": " + count++);
                // 唤醒其他线程
                lock.notifyAll();

                try {
                    if (count <=  100) {
                        lock.wait();
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new TurningRunner(), "偶数").start();
        // 确保偶数线程线先获取到锁
        Thread.sleep(1);
        new Thread(new TurningRunner(), "奇数").start();
    }
}