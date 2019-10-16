package com.lx.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
       // station3.start();
//        for (int i = 1; i <= 3; i++) {
//            Station station = new Station("窗口" + i);
//            station.start();
//
//        }
        //test3();
//        long start = 1565441927257L;
//        long end = 1565441952829L;
//        System.out.println(102643 / 25572);
    }

    private static void test() {
        for (int i = 0; i < 5; i++) {
            Station2 s = new Station2();
            Thread t = new Thread(s);
            t.start();
        }
    }

    private static void test3() {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        System.out.println(System.currentTimeMillis());
        //pool.execute(new Station2());

        for (int i = 0; i < 4; i++) {
            pool.execute(new Station2());
        }
    }



}