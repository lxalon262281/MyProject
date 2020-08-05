package com.lx.Singleton;

/**
 * 懒汉模式
 */
public class SingletonPatternB {

    public static SingletonPatternB instance = null;

    private SingletonPatternB() {}

    /**
     * 这个方法可以保证线程的同步，但是效率太低，因为大多数情况下不需要同步
     * @return
     */
    public static synchronized SingletonPatternB getInstance() {
        if(instance == null){
            instance = new SingletonPatternB();
        }
        return instance;
    }
}
