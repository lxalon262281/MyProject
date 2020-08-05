package com.lx.demo.proxy.DynamicProxy;

import com.lx.demo.proxy.Person;
import com.lx.demo.proxy.Student;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理,动态代理类不要显示的实现被代理类所实现的接口
 * @author yujie.wang
 *
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    /**
     * 动态代理实现代码，我们看到这里涉及到java反射包下的一个接口InvocationHandler和一个类Proxy。
     * 这个接口只有一个invoke方法，我们在通过代理类调用被代理类的方法时，最终都会委托给这个invoke方法执行，所以我们就可以在这个invoke方法中对被代理类进行增强或做一些其他操作。
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("MyInvocationHandler invoke begin");
        System.out.println("proxy: "+ proxy.getClass().getName());
        System.out.println("method: "+ method.getName());
        for(Object o : args){
            System.out.println("arg: "+ o);
        }
        //通过反射调用 被代理类的方法
        method.invoke(object, args);
        System.out.println("MyInvocationHandler invoke end");
        return null;
    }


    /**
     * Proxy类的public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)方法内部通过拼接字节码的方式来创建代理类，后面我会反编译出它所创建的代理类看看内容。
     *我们看这个方法的三个参数：
     *
     * ClassLoader loader：指定一个动态加载代理类的类加载器
     *
     * Class<?>[] interfaces：指明被代理类实现的接口，之后我们通过拼接字节码生成的类才能知道调用哪些方法。
     *
     * InvocationHandler h：这是一个方法委托类，我们通过代理调用被代理类的方法时，就可以将方法名和方法参数都委托给这个委托类。
     *
     * 现在有了类加载器、类实现的接口、要调用方法的方法名和参数，那么我们就可以做很多事情了。
     *
     * 反编译Proxy.newProxyInstance所创建的代理类
     *
     * //这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
     * System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
     *
     * 我们在代码中加入上述代码，代码就会保存生成的代理类，名称为$Proxy0.class
     *
     */
    public static void main(String [] args){
        //创建需要被代理的类
        Student s = new Student();

        //这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        //获得加载被代理类的 类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        //通过反射获取（指明）被代理类实现的接口
        Class<?>[] interfaces = s.getClass().getInterfaces();

        //创建被代理类的委托类,之后想要调用被代理类的方法时，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法
        MyInvocationHandler h = new MyInvocationHandler(s);

        //生成代理类
        Person proxy = (Person) Proxy.newProxyInstance(loader, interfaces, h);

        //通过代理类调用 被代理类的方法
        proxy.sayHello("yujie.wang", 20);
        proxy.sayGoodBye(true, 100);
        System.out.println("end");
    }

    /**
     * jdk的代理让我们在不直接访问某些对象的情况下，通过代理机制也可以访问被代理对象的方法，这种技术可以应用在很多地方比如RPC框架，Spring AOP机制，
     * 但是我们看到jdk的代理机制必须要求被代理类实现某个方法，这样在生成代理类的时候才能知道重新那些方法。这样一个没有实现任何接口的类就无法通过jdk的代理机制进行代理，
     * 当然解决方法是使用cglib的代理机制进行代理。
     *
     * 动态代理的好处
     * Java动态代理的优势是实现无侵入式的代码扩展，也就是方法的增强；让你可以在不用修改源码的情况下，增强一些方法；在方法的前后你可以做你任何想做的事情（甚至不去执行这个方法就可以）。
     *
     * 1.动态代理是设计模式中的代理模式：
     * 定义：为其它对象提供一种代理以控制对这个对象的访问控制；在某些情况下，客户不想或者不能直接引用另一个对象，这时候代理对象可以在客户端和目标对象之间起到中介的作用。
     *
     * 2.静态代理
     * 静态代理类：由程序员创建或者由第三方工具生成，再进行编译；在程序运行之前，代理类的.class文件已经存在了。
     * 静态代理类通常只代理一个类。
     * 静态代理事先知道要代理的是什么。
     * 3.动态代理
     * 动态代理类：在程序运行时，通过反射机制动态生成。
     * 动态代理类通常代理接口下的所有类。
     * 动态代理事先不知道要代理的是什么，只有在运行的时候才能确定。
     * 动态代理的调用处理程序必须事先InvocationHandler接口，及使用Proxy类中的newProxyInstance方法动态的创建代理类。
     * Java动态代理只能代理接口，要代理类需要使用第三方的CLIGB等类库。
     *
     */

}