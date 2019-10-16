package com.lx.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TaskB implements Runnable {

    private Condition condition;
    private Lock lock;
    public TaskB(Condition condition,Lock lock) {
        this.condition = condition;
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("线程 B 拿到了锁，开始工作");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------");
        try {
            System.out.println("线程 B 发信号了，完成工作");
            condition.signal();
        } finally {
            System.out.println("线程 B 释放了锁");
            lock.unlock();
        }
    }
}
