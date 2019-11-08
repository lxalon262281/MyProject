package com.lx.demo.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptLock {
    private ReentrantLock lock = new ReentrantLock();

    public void B() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + "获取锁...");
            while (true) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "执行...");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被打断...");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        InterruptLock lock2 = new InterruptLock();
        Thread t1 = new Thread(() -> { lock2.B(); });
        t1.start();
        Thread t2 = new Thread(() -> { lock2.B(); });
        t2.start();
        Thread.sleep(2000);
        System.out.println(t1.getName() + ": "+t1.getState());// RUNNABLE 正在运行
        System.out.println(t2.getName() + ": "+t2.getState());// WAITING 等待状态
        Thread.sleep(1000);
        t2.interrupt();// 打断t2线程
        System.out.println(t2.getName() + ": "+t2.getState());// WAITING 状态(线程延时)
    }
}