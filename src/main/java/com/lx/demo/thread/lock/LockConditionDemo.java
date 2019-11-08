package com.lx.demo.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
