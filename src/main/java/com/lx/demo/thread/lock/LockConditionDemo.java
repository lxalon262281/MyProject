package com.lx.demo.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskB implements Runnable {

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

class TaskA implements Runnable{
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
public class LockConditionDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread t1 = new Thread(new TaskA(condition,lock));
        t1.start();
        Thread t2 = new Thread(new TaskB(condition,lock));
        t2.start();
    }

}
