package com.lx.demo.thread;


/**
 * 死锁demo
 */
class Thread11 extends Thread {
    Object lockA = null;
    Object lockB = null;

    public Thread11(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("*** Thread 11: ***: Lock A");
            synchronized (lockB) {
                System.out.println("*** Thread 11: ***: Lock B");
            }
        }

    }

}

class Thread12 extends Thread {
    Object lockA = null;
    Object lockB = null;

    public Thread12(Object lockA, Object lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }
    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println("*** Thread 12: ***: Lock B");
            synchronized (lockB) {
                System.out.println("*** Thread 12: ***: Lock A");
            }
        }
    }
}



public class ThreadTest2 {

    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();
        Thread11 t1 = new Thread11(lockA,lockB);
        Thread12 t2 = new Thread12(lockA,lockB);

        t1.start();
        t2.start();
    }
}
