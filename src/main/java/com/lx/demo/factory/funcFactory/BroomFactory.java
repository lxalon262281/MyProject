package com.lx.demo.factory.funcFactory;

public class BroomFactory extends VehicleFactory{
    @Override
    Moveable create() {
        return new Broom();
    }
}
