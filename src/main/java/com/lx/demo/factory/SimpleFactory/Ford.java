package com.lx.demo.factory.SimpleFactory;

class Ford extends Car {
    public void run() {
        System.out.println("Ford开始启动了。。。");
    }

    public void stop() {
        System.out.println("Ford停车了。。。。");
    }
}