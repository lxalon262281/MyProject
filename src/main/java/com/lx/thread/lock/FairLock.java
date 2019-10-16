package com.lx.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 * ReentrantLock 即可重入锁,当一个线程请求得到一个对象锁后再次请求此对象锁，可以再次得到该对象锁。
 */
public class FairLock {

    private ReentrantLock lock = new ReentrantLock(false);

    public synchronized void A() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "获得锁...");
        try {
            Thread.sleep(10);
            System.out.println(Thread.currentThread().getName() + "执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLock fairLock = new FairLock();
        new Thread(() -> {
            fairLock.A();
        }).start();// 启动线程获得锁

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "等待获得锁...");
                fairLock.A();
            }).start();
        }
    }
}