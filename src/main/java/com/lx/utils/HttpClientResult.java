package com.lx.utils;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.io.Serializable;

public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(int code,String content) {
        this.content = content;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }
}
