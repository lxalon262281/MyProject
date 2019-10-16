package com.lx.oom;

public class OOMDemo {
    public static void main(String[] args) {
        String[] list = new String[1024 * 1024 * 1024 * 1024 * 1024 * 2048];
        System.out.println("test");
    }
}
