package com.lx;

/**
 * 饿汉式单例模式，本身是一种线程安全的方法，再类创建的时候，对象就生成了，所以不存在线程同步的问题
 */
public class SingletonPatternC {
    public static SingletonPatternC instance = new SingletonPatternC();

    private SingletonPatternC() {

    }

    public SingletonPatternC getInstance() {
        return instance;
    }
}
