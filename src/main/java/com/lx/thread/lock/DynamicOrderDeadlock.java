package com.lx.thread.lock;

import java.util.concurrent.atomic.AtomicInteger;

//动态的锁的顺序死锁
public class DynamicOrderDeadlock {

    public static void transferMoney(Account fromAccount,Account toAccount,int amount,int from_index,int to_index) throws Exception {
        System.out.println("账户 "+ from_index+"~和账户~"+to_index+" ~请求锁");

        synchronized (fromAccount) {
            System.out.println("    账户 >>>"+from_index+" <<<获得锁");
            synchronized (toAccount) {
                System.out.println("          账户   "+from_index+" & "+to_index+"都获得锁");
                if (fromAccount.compareTo(amount) < 0) {
                    throw new Exception();
                }else {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }
    static class Account {
        private int balance = 100000;//这里假设每个人账户里面初始化的钱
        private final int accNo;
        private static final AtomicInteger sequence = new AtomicInteger();

        public Account() {
            accNo = sequence.incrementAndGet();
        }

        void debit(int m) throws InterruptedException {
            Thread.sleep(5);//模拟操作时间
            balance = balance + m;
        }

        void credit(int m) throws InterruptedException {
            Thread.sleep(5);//模拟操作时间
            balance = balance - m;
        }

        int getBalance() {
            return balance;
        }

        int getAccNo() {
            return accNo;
        }

        public int compareTo(int money) {
            if (balance > money) {
                return 1;
            }else if (balance < money) {
                return -1;
            }else {
                return 0;
            }
        }
    }
}