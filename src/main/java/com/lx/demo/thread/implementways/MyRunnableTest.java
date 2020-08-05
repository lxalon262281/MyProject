package com.lx.demo.thread.implementways;

/**
 * 实现Runnable接口方式实现多线程，无返回参数
 */
class MyRunnable implements Runnable {
    private String taskName;
    //通过构造方法给线程名字赋值
    public MyRunnable(String name) {
        this.taskName = name; // 给线程名字赋值
    }

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
                    System.out.println(this.taskName + ":卖出了第" + tick + "张票");
                    tick--;
                    if (tick == 1) {
                        System.out.println(System.currentTimeMillis());
                    }
                } else {
                    System.out.println(this.taskName + ":票卖完了" + "----" + System.currentTimeMillis());
                }

            }
            try {
                Thread.sleep(100);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


public class MyRunnableTest {

    public static void main(String[] args) {
//        MyRunnable myRunnable1 = new MyRunnable("线程1");
//        MyRunnable myRunnable2 = new MyRunnable("线程2");
//
//        Thread t1 = new Thread(myRunnable1);
//        Thread t2 = new Thread(myRunnable2);
//
//        t1.start();
//        t2.start();


        for (int i = 0; i < 2; i++) {
            MyRunnable myRunnable = new MyRunnable("t" + i);
            Thread thread = new Thread(myRunnable);
            thread.start();
        }
    }

}

