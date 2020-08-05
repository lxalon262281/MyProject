package com.lx.demo.factory.funcFactory;

//具体工厂类
public class PlaneFactory extends VehicleFactory{
    @Override
    Moveable create() {
        return new Plane();
    }
}
