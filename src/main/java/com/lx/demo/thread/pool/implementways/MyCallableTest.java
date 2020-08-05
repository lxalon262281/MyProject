package com.lx.demo.thread.pool.implementways;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口方式实现多线程，有返回参数
 */
class MyCallable implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        double d = 0;
        try {
            System.out.println("异步计算开始.......");
            d = Math.random() * 10;
            d += 100;
            Thread.sleep(2000);
            System.out.println("异步计算结束.......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return d;
    }
}

public class MyCallableTest {

    public static void main(String[] args) {
        try {
            MyCallable myCallable = new MyCallable();
            FutureTask<Double> task = new FutureTask(myCallable);
            Thread thread = new Thread(task);
            thread.start();
            //主线程继续工作
            Thread.sleep(1000);
            System.out.println("主线程等待计算结果...");

            //当需要用到异步计算的结果时，阻塞获取这个结果
            Double d = task.get();
            System.out.println("计算结果是："+d);

            //用同一个 FutureTask 再起一个线程
            Thread thread2 = new Thread(task);
            thread2.start();

        } catch (Exception e) {
            e.getMessage();
        }
    }

}
