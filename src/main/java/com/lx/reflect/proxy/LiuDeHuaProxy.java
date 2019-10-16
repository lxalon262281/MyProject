package com.lx.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LiuDeHuaProxy {
    //设计一个类变量实现这个代理类代理的真实对象类
    private Person person = new LiuDeHua();

    public Person getproxy2() {
        Person zhangsan =(Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            //如果调用的是代理人对象的sing方法
                            System.out.println("我是刘德华的代理人，要找刘德华唱歌需要一百万！！");
                            //已经交钱，代理人自己不会唱歌就只能找刘德华唱歌了
                            //代理对象调用真实目标对象的sing方法去处理用户请求
                            return method.invoke(person, args);
                        }
                        System.out.println();
                        if (method.getName().equals("dance")) {
                            //如果调用的是代理人对象的dance方法
                            System.out.println("我是刘德华的代理人，要找刘德华跳舞需要一百万！！");
                            //已经交钱，代理人自己不会跳舞就只能找刘德华跳舞了
                            //代理对象调用真实目标对象的dance方法去处理用户请求
                            return method.invoke(person, args);
                        }
                        return null;
                    }
                });
        return null;

    }
    public Person getProxy() {
        System.out.println("5");
        Person LiuDeHua = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                /**
                 * InvocationHandler接口只定义了一个invoke方法，因此对于这样的接口，我们不用单独去定义一个类来实现该接口，
                 * 而是直接使用一个匿名内部类来实现该接口，new InvocationHandler() {}就是针对InvocationHandler接口的匿名实现类
                 * 在invoke方法编码指定返回的代理对象干的工作
                 * proxy : 把代理对象自己传递进来
                 * method：把代理对象当前调用的方法传递进来
                 * args:把方法参数传递进来
                 *
                 * 当调用代理对象的person.sing("冰雨");或者 person.dance("江南style");方法时，
                 * 实际上执行的都是invoke方法里面的代码，
                 * 因此我们可以在invoke方法中使用method.getName()就可以知道当前调用的是代理对象的哪个方法
                 */
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("7");
                        if (method.getName().equals("sing")) {
                            //如果调用的是代理人对象的sing方法
                            System.out.println("我是刘德华的代理人，要找刘德华唱歌需要一百万！！");
                            //已经交钱，代理人自己不会唱歌就只能找刘德华唱歌了
                            //代理对象调用真实目标对象的sing方法去处理用户请求
                            return method.invoke(person, args);
                        }
                        System.out.println("8");
                        if(method.getName().equals("dance")){
                            //如果调用的是代理人对象的dance方法
                            System.out.println("我是刘德华的代理人，要找刘德华跳舞需要一百万！！");
                            //已经交钱，代理人自己不会跳舞就只能找刘德华跳舞了
                            //代理对象调用真实目标对象的dance方法去处理用户请求
                            return method.invoke(person, args);
                        }
                        System.out.println("9");
                        return null;
                    }
                });
        System.out.println("6");
        return LiuDeHua;
    }

    public static void main(String[] args) {
//        System.out.println("1");
//        LiuDeHuaProxy proxy = new LiuDeHuaProxy();
//        System.out.println("2");
//        Person person = proxy.getProxy();
//        System.out.println("3");
//        person.sing("坏小孩");
        //System.out.println("4");

        Person person2 = new LiuDeHua();

        PersonHandler personHandler = new PersonHandler(person2);

        Person p = (Person)personHandler.getProxy();
        p.dance("忘情水");

    }
}
