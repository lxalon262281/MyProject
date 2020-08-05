package com.lx.Singleton;

/**
 * 饿汉模式：延迟加载
 */
public class SingletonPatternD {
    public static SingletonPatternD instance = new SingletonPatternD();

    public SingletonPatternD() {

    }

    public static SingletonPatternD getInstance() {
        return instance;
    }
}
