package com.lx.thread;

public class Station2 implements Runnable {
    // 通过构造方法给线程名字赋值
//    public Station2(String name) {
//        super(name);// 给线程名字赋值
//    }

    // 为了保持票数的一致，票数要静态
    static int tick = 30;

    // 创建一个静态钥匙
    static Object ob = "aa";//值是任意的

    // 重写run方法，实现买票操作
    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {// 这个很重要，必须使用一个锁，
                // 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
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
//                System.out.println(Thread.currentThread().getName() + " 开始卖票");
            }
            try {
                Thread.sleep(100);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
