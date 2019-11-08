package com.lx.demo.thread.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadPoolDemo {
//    public static void main(String[] args) {
//        executeTask();
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("This is ThreadPoolExetor#submit(Callable<T> task) method.");
//                return "result";
//            }
//        };
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<String> future = executor.submit(callable);
//        System.out.println(future.get());
        executeTask();
    }
    public static void executeTask() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        try {

            for (int i = 0;i < 60;i++) {
//            pool.execute(new Thread(){
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//                pool.execute();
                Future<Object> result = pool.submit(new TaskDemo());
                try {
                    Object s = result.get();
                    System.out.println(s);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.getMessage();
                } catch (Exception e) {
                    e.getMessage();
                }

            }
        } catch (Exception e) {

        } finally {
            pool.shutdown();
        }
    }

    static class TaskDemo implements Callable {
        ThreadLocal<SimpleDateFormat> SDF = new ThreadLocal<SimpleDateFormat>(){
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("HH:mm:ss");
            }
        };

        @Override
        public String call() throws Exception {
            String time = SDF.get().format(new Date());
            System.out.println(Thread.currentThread().getName() + "---" + time);
            return time;
        }
    }
}
