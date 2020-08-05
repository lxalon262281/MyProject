package com.lx.utils;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class HttpClientApplication {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zhangsan");
        map.put("password", "123456");
        String params = JSON.toJSONString(map);
        System.out.println(params);
//        String url = "http://127.0.0.1:8888/post/with/headers";
        String url = "http://localhost:8888/v1/login";
        HttpClient httpClient = null;
        HttpPost postMethod = null;
        HttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            postMethod = new HttpPost(url);//传入URL地址
            //设置请求头
            postMethod.addHeader("Content-type", "application/json");
//            postMethod.addHeader("X-Authorization", "AAAA");//设置请求头
            //传入请求参数
            postMethod.setEntity(new StringEntity(params, Charset.forName("UTF-8")));
            response = httpClient.execute(postMethod);//获取响应
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("HTTP Status Code:" + statusCode);
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("HTTP请求未成功！HTTP Status Code:" + response.getStatusLine());
            }
            HttpEntity httpEntity = response.getEntity();
            String reponseContent = EntityUtils.toString(httpEntity);
            EntityUtils.consume(httpEntity);//释放资源
            System.out.println("响应内容：" + reponseContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
