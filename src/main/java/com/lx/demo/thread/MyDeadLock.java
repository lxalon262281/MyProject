package com.lx.demo.thread;

public class MyDeadLock {
    public static Object objA = new Object();
    public static Object objB = new Object();

    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1(objA,objB);
        MyThread2 t2 = new MyThread2(objA,objB);
        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {
    public Object objA;
    public Object objB;
    public MyThread1(Object lockA, Object lockB) {
        this.objA = lockA;
        this.objB = lockB;
    }
    @Override
    public void run() {
        synchronized(objA) {
            synchronized (objB) {

            }
        }
    }
}

class MyThread2 extends Thread {
    public Object objA;
    public Object objB;
    public MyThread2(Object lockA, Object lockB) {
        this.objA = lockA;
        this.objB = lockB;
    }
    @Override
    public void run() {
        synchronized(objB) {
            synchronized (objA) {

            }
        }
    }
}