package com.lx.demo.thread;

public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0 ;i < 10; i++) {
            System.out.println("当前线程是： " + Thread.currentThread().getName());
        }


    }

}
