package com.lx.demo.factory.SimpleFactory;

//工厂类
public class Factory {
    public static Car getCarInstance(String type) {
        Car car = null;

        if("Benz".equals(type)) {
            car = new Benz();
        } else if ("Ford".equals(type)) {
            car = new Ford();
        }

        return car;
    }
}
