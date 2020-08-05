package com.lx.demo.factory.SimpleFactory;


// 具体实现类
public class Benz extends Car {
    public void run() {
        System.out.println("Benz开始启动了。。。。。");
    }

    public void stop() {
        System.out.println("Benz停车了。。。。。");
    }

}
