package com.lx.demo.reflect.proxy;

public class LiuDeHua implements Person {

    @Override
    public String sing(String name) {
        System.out.println("刘德华唱"+name+"歌");
        return "歌唱完了";
    }

    @Override
    public String dance(String name) {
        System.out.println("刘德华跳"+name+"w舞蹈");
        return "舞蹈跳完了";
    }
}
