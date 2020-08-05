package com.lx.demo.thread.implementways;

/**
 * 继承Thread类的方式实现多线程
 * 实现方法可以归为两类：继承类和实现接口两种方式。相比继承， 接口实现可以更加灵活，不会受限于Java的单继承机制。
 * 并且通过实现接口的方式可以共享资源，适合多线程处理同一资源的情况。线程知识丰富繁杂
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0 ;i < 10; i++) {
            System.out.println(i + " ---- 当前线程是： " + Thread.currentThread().getName());
        }

    }
}

public class MyThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();

    }
}
