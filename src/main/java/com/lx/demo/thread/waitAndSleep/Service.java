package com.lx.demo.thread.waitAndSleep;

public class Service {
    public void mSleep() {
        synchronized (this) {
            try {
//                System.out.println("Sleep : 当前时间 " + System.currentTimeMillis());
//                Thread.sleep(3 * 1000);
                Thread.sleep(3*1000);
                this.notifyAll();
                System.out.println(" 唤醒等待 : 结束时间："+System.currentTimeMillis());
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    public void mWait() {
        synchronized (this) {
            try {
//                System.out.println("Wait: 结束时间："+ System.currentTimeMillis());
                System.out.println(" 等待开始 : 当前时间："+System.currentTimeMillis());
                this.wait();
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }
}
