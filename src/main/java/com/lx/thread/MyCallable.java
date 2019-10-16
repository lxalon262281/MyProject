package com.lx.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        double d = 0;
        try {
            System.out.println("异步计算开始.......");
            d = Math.random()*10;
            d += 1000;
            Thread.sleep(2000);
            System.out.println("异步计算结束.......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return d;
    }
}
