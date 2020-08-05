package com.lx.demo.thread.waitAndSleep;

public class WaitThread implements Runnable{
    private Service service;

    public WaitThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.mWait();
    }
}
