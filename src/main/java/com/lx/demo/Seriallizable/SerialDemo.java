package com.lx.demo.Seriallizable;

import org.apache.tools.ant.Executor;

import java.io.*;
import java.nio.Buffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialDemo {
    public static void main(String[] args) throws IOException,ClassNotFoundException{

        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        User user1 = new User("xiaoming","145263","female");
        oos.writeObject(user1);
        System.out.print(oos);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois=new ObjectInputStream(fis);
        User user2=(User) ois.readObject();
        System.out.print(user2.getUserName("xiaoming")+" "+ user2.getPassword("145263")+" " + user2.getSex("female"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newFixedThreadPool(1);
        Executors.newSingleThreadExecutor();
    }
}
