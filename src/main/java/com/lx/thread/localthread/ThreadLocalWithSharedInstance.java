package com.lx.thread.localthread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadLocalWithSharedInstance implements Runnable {

    // list 是一个事实共享的实例，即使被 ThreadLocal 修饰
    private static List<String> list = new ArrayList<>();
    private ThreadLocal<List<String>> threadLocal = ThreadLocal.withInitial(() -> list);

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            List<String> li = threadLocal.get();
            li.add(Thread.currentThread().getName() + "_" + new Random().nextInt(10)+"");
            threadLocal.set(li);
        }
        System.out.println("[Thread-" + Thread.currentThread().getName() + "], list=" + threadLocal.get());
    }

    public static void main(String[] args) throws Exception {
        Thread ta = new Thread(new ThreadLocalWithSharedInstance(), "a");
        Thread tb = new Thread(new ThreadLocalWithSharedInstance(), "b");
        Thread tc = new Thread(new ThreadLocalWithSharedInstance(), "c");
        ta.start();
        ta.join();
        tb.start();
        tb.join();
        tc.start();
        tc.join();
    }
}