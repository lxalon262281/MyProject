package com.lx.demo.thread.lock;

class myThread implements Runnable{
    private boolean flag ;
    private Object object ;

    myThread(boolean flag, Object o){
        this.flag = flag;
        this.object = o;
    }
    private void waitThread(){
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "wait begin...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "wait end...");
        }
    }
    private void notifyThread(){
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "notify begin...");
            object.notifyAll();
            System.out.println(Thread.currentThread().getName() + "notify end...");
        }
    }
    @Override
    public void run() {
        if(flag){
            waitThread();
        } else {
            notifyThread();
        }
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        myThread mt2 = new myThread(false,object);
        Thread thread1 = new Thread(mt2,"线程B ");
        for (int i = 0;i<10;i++) {
            myThread mt = new myThread(true,object);
            Thread thread = new Thread(mt,"线程A "+i);
            thread.start();
        }
        Thread.sleep(1000);
        thread1.start();
    }
}