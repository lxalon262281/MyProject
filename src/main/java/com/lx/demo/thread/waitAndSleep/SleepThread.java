package com.lx.demo.thread.waitAndSleep;

public class SleepThread implements Runnable {
    private Service service;

    public SleepThread(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        this.service.mSleep();
    }
}
