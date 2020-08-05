package com.lx.demo.factory.funcFactory;

// 具体产品角色
public class Broom implements Moveable{
    @Override
    public void run() {
        System.out.println("broom...");
    }
}
