package com.lx.demo.factory.funcFactory;

import com.lx.demo.factory.SimpleFactory.Car;
import com.lx.demo.factory.SimpleFactory.Factory;

public class Test {
    public static void main(String[] args) {
        VehicleFactory factory = new PlaneFactory();
        Moveable plane = factory.create();
        plane.run();

    }
}
