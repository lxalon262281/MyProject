package com.lx.demo.thread;

import java.util.concurrent.*;


/**
 * 卖票
 */
class Station2 implements Runnable {
    static int tick = 300;

    static Object ob = "aa";//值是任意的

    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {
                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖出了第" + tick + "张票");
                    tick--;
                    if (tick == 1) {
                        System.out.println(System.currentTimeMillis());
                    }
                } else {
                    System.out.println("票卖完了");
                    System.out.println(System.currentTimeMillis());
                }
            }
            try {
                Thread.sleep(10);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
public class MainClass {
    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     * */
    public static void main(String[] args) {
        //实例化站台对象，并为每一个站台取名字
        Station station1 = new Station("窗口1");
        Station station2 = new Station("窗口2");
       // Station station3 = new Station("窗口3");
        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
//        station3.start();
//        for (int i = 1; i <= 3; i++) {
//            Station station = new Station("窗口" + i);
//            station.start();
//
//        }
        //test3();
    }

    private static void test() {
        for (int i = 0; i < 3; i++) {
            Station2 s = new Station2();
            Thread t = new Thread(s);
            t.start();
        }
    }

    private static void test3() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,5,0,
                TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());
        //ExecutorService pool = Executors.newFixedThreadPool(4);



        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(new Station2());
        }
        poolExecutor.shutdown();
    }



}