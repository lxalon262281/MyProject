package com.lx.demo.thread;

public class Test2 {

    public static void main(String[] args) throws Exception{
        Object lock = new Object();
        new Thread(new Thread1()).start();
        try{
            System.out.println("start -----------------");
            //Thread.sleep(200000);
            System.out.println("end -----------------");
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();
    }

}

class Thread1 implements Runnable{

    @Override
    public void run() {

        System.out.println("Thread1 start");

        synchronized (Test.class){

            System.out.println("Thread1 in lock");
            try {
                Thread.sleep(2000);   //1
                System.out.println("Thread1 start wait");
                Test.class.wait();
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Thread1 end wait and process on"); //5
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {

        System.out.println("Thread2 start");  //2

        synchronized (Test.class){
            System.out.println("Thread2 in lock");  //3
            try {
                System.out.println("Thread2 start notify");
                for(int i = 0;i<100;i++){   //4
                    System.out.print(i+"_");
                    if(i==50){
                        Thread.sleep(3000);
                        System.out.println("\n");
                    }
                }
                //Test.class.notify();
                System.out.println("\n");
                System.out.println("Thread2 end notify");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}