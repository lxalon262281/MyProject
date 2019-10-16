package com.lx.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class TaskA implements Runnable{
    private Condition condition;
    private Lock lock;
    public TaskA(Condition condition,Lock lock) {
        this.condition = condition;
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("线程 A 拿到了锁，开始工作");
        try {
            System.out.println("线程 A 释放了锁，进入等待状态");
            condition.await();
            System.out.println("线程 A 收到信号，继续工作");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程 A 释放了锁");
            lock.unlock();
        }
    }
}
