package com.lx.demo.proxy.staticProxy;

import com.lx.demo.proxy.Person;
import com.lx.demo.proxy.Student;

/**
 * 静态代理，这个代理类也必须要实现和被代理类相同的Person接口
 */
public class ProxyTest implements Person {

    private Person person;

    public ProxyTest(Person p){
        this.person = p;
    }

    @Override
    public void sayHello(String content, int age) {
        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        person.sayHello(content, age);
        System.out.println("ProxyTest sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        person.sayGoodBye(seeAgin, time);
        System.out.println("ProxyTest sayHello end");
    }

    /**
     * 静态代理看起来是比较简单的，没有什么问题只不过是在代理类中引入了被代理类的对象而已。
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //s为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
        Student s = new Student();
        //创建代理类对象
        ProxyTest proxy = new ProxyTest(s);
        //调用代理类对象的方法
        proxy.sayHello("welcome to java", 20);
        System.out.println("******");
        //调用代理类对象的方法
        proxy.sayGoodBye(true, 100);

    }

}
