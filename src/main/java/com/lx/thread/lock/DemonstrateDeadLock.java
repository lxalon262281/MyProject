package com.lx.thread.lock;

import java.util.Random;

public class DemonstrateDeadLock {
    private static final int NUM_THREADS = 5;
    private static final int NUM_ACCOUNTS = 5;
    private static final int NUM_ITERATIONS = 100000;

    public static void main(String[] args) {
        final Random rnd = new Random();
        final DynamicOrderDeadlock.Account[] accounts = new DynamicOrderDeadlock.Account[NUM_ACCOUNTS];

        for(int i = 0;i < accounts.length;i++) {
            accounts[i] = new DynamicOrderDeadlock.Account();
        }


        class TransferThread extends Thread{
            @Override
            public void run() {
                for(int i = 0;i < NUM_ITERATIONS;i++) {
                    int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
                    int toAcct =rnd.nextInt(NUM_ACCOUNTS);
                    int amount = rnd.nextInt(100);
                    try {
                        DynamicOrderDeadlock.transferMoney(accounts[fromAcct],accounts[toAcct], amount,fromAcct,toAcct);
                        //InduceLockOrder.transferMoney(accounts[fromAcct],accounts[toAcct], amount);
                        //InduceLockOrder2.transferMoney(accounts[fromAcct],accounts[toAcct], amount);
                    }catch (Exception e) {
                        System.out.println("发生异常-------"+e);
                    }
                }
            }
        }

        for(int i = 0;i < NUM_THREADS;i++) {
            new TransferThread().start();
        }
    }

}