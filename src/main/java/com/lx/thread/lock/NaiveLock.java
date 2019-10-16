package com.lx.thread.lock;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NaiveLock {

    private static final long NONE=-1;
    private long owner =NONE;

    public synchronized void lock(){
        long currentThreadId=Thread.currentThread().getId();
        if(owner==currentThreadId){
            throw new IllegalStateException("lock has been acquired by current thread");
        }

        while(this.owner!=NONE){

            System.out.println(String.format("thread %s is waiting lock", currentThreadId));
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.owner=currentThreadId;
        System.out.println(String.format("lock is acquired by thread %s", currentThreadId));

    }

    public synchronized void unlock(){

        long currentThreadId=Thread.currentThread().getId();

        if(this.owner!=currentThreadId){
            throw new IllegalStateException("Only lock owner can unlock the lock");
        }

        System.out.println(String.format("thread %s is unlocking", owner));
        owner=NONE;
        notify();

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final NaiveLock lock=new NaiveLock();
        ExecutorService executor= Executors.newFixedThreadPool(20, new ThreadFactory(){
            private ThreadGroup group =new ThreadGroup("test thread group");
            {
                group.setDaemon(true);
            }
            @Override
            public Thread newThread(Runnable r) {
                // TODO Auto-generated method stub
                return new Thread(group,r);
            }});


        for(int i=0;i<20;i++){
            executor.submit(new Runnable(){

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    lock.lock();
                    System.out.println(String.format("thread %s is running...", Thread.currentThread().getId()));


                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lock.unlock();
                }});
        }


    }

}