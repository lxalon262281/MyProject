package com.lx.demo.thread;

public class Ticket implements Runnable {



//    public Ticket(String name) {
//        super(name);
//    }

    private int ticket = 100;
    @Override
    public void run() {
        synchronized (this) {
            if (ticket > 0) {
                ticket--;
                System.out.println("线程" + Thread.currentThread().getName() + "卖了一张票");
            } else {
                System.out.println("卖完了");
            }
        }

    }
}
