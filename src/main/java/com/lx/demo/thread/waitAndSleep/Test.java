package com.lx.demo.thread.waitAndSleep;

public class Test {
    public static void main(String[] args) {
        Service service = new Service();

        Thread t1 = new Thread(new SleepThread(service));
        Thread t2 = new Thread(new WaitThread(service));

        t2.start();
        t1.start();
    }
}
