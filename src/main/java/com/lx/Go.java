package com.lx;

public class Go {
    public static int i = 0;

    public static void main(String[] args) {
        int reult = calc("", 5);
        System.out.println("总共有" + reult + "种走法~");
    }

    //上楼梯每次只需一步或者两步，有多少走法
    public static int calc(String log, int num) {
        if (num <= 2)
            return num;
        int x = calc(log + "1,", num - 1) + calc(log + "2,", num - 2);
        return x;
    }
}
