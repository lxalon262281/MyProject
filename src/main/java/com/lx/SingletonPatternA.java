package com.lx;


/**
 * 单例
 */
public class SingletonPatternA {
    public static SingletonPatternA instance = null;

    private SingletonPatternA(){}


    /**
     * 这个写法是饿汉单例模式，但也是是属于线程不安全的写法。如果多线程同时来进行getInstance的操作，
     * 那么这个时候进入if(instance == null)判断时就需要加入线程同步的方法了
     * @return
     */
    public static SingletonPatternA getInstance() {
        if (instance == null) {
            instance = new SingletonPatternA();
        }
        return instance;
    }
}
