package com.lx.thread;

public class ARunnable implements Runnable {

    volatile boolean stop;

    private static Integer count = 20;

    void tellToStop() {
        stop = true;
    }
    private String taskName;

    public ARunnable(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
//            System.out.println("进入不可停止区域 1。。。");
//            Thread.sleep(5 * 100);
//            System.out.println("退出不可停止区域 1。。。");
//            System.out.println("检测标志stop = "+ String.valueOf(stop));
//            if (stop) {
//                System.out.println("停止执行");
//                return;
//            }
//            System.out.println("进入不可停止区域 2。。。");
//            Thread.sleep(5 * 100);
////            System.out.println("退出不可停止区域 2。。。");
//            System.out.println("当前线程是："+Thread.currentThread().getName());


            for (int i = 0;i < count; i++) {
                System.out.println("执行的当前线程是： " + Thread.currentThread().getName() + " --" + i);
            }
//            System.out.println("线程池完成任务："+ Thread.currentThread().getName());

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
