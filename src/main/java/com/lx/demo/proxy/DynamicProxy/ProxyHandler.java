package com.lx.demo.proxy.DynamicProxy;

import com.lx.demo.proxy.Person;
import com.lx.demo.proxy.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("sayHello")) {
            System.out.println("ssssss");
            method.invoke(object,args);
            System.out.println("eeeeee");

        } else if (method.getName().equals("sayGoodBye")) {
            System.out.println("11111");
            method.invoke(object,args);
            System.out.println("2222");
        }
        return null;
    }


    public static void main(String[] args) {
        //创建需要被代理的类
        Student s = new Student();

        //生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获得代理类的类加载器
        ClassLoader cl = Thread.currentThread().getContextClassLoader();

        //通过反射获取（指明）被代理类实现的接口
        Class<?>[] interfaces = s.getClass().getInterfaces();

        //获得被代理类的委托类，以后调用被代理类的方法就是调用委托类的invoke方法
        ProxyHandler proxyHandler = new ProxyHandler(s);

        //获取代理类
        Person student = (Person)Proxy.newProxyInstance(cl,interfaces,proxyHandler);
        student.sayHello("aaaa",20);
        student.sayGoodBye(true,2);
//
//        HelloInterface hello = new Hello();
//
//        InvocationHandler handler = new ProxyHandler1(hello);
//
//        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
//
//        proxyHello.sayHello();

    }
}
