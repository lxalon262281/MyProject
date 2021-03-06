package com.lx.demo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 线程池demo
 */
public class Test {
    public static void main(String[] args) {
        ARunnable t1 = new ARunnable("任务1");
        ARunnable t2 = new ARunnable("任务2");


        //useFutureTask();
        useExecutor();
    }
//
//    public static void useFutureTask() {
//        try {
//            MyCallable myCallable = new MyCallable();
//            FutureTask<Double> task = new FutureTask(myCallable);
//            Thread thread = new Thread(task);
//            thread.start();
//            //主线程继续工作
//            Thread.sleep(1000);
//            System.out.println("主线程等待计算结果...");
//
//            //当需要用到异步计算的结果时，阻塞获取这个结果
//            Double d = task.get();
//            System.out.println("计算结果是："+d);
//
//            //用同一个 FutureTask 再起一个线程
//            Thread thread2 = new Thread(task);
//            thread2.start();
//
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }

    public static void useExecutor() {
        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 30; i++) {
            pool.execute(new ARunnable("任务1"));
        }

//        //提交任务
//        pool.execute(new ARunnable("任务1"));
//        pool.execute(new ARunnable("任务2"));
//        pool.execute(new ARunnable("任务3"));
//        pool.execute(new ARunnable("任务4"));


    }
}
