package com.lx.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionUtil {

    /** 请求方式1 ： GET*/
    public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// 返回结果字符串
        try {
            // 创建远程url连接对象
            URL url = new URL(httpurl);
            connection = getConnection(url,"GET");
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            result = getResult(connection,is,null,br);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(connection,is,null,br);
        }
        System.out.println(result);
        return result;
    }

    /** 请求方式： POST*/
    public static String doPost(String httpUrl, String param) {
        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开连接
            connection = getConnection(url,"POST");

            // 通过连接对象获取一个输出流
            os = connection.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
            os.write(param.getBytes());

            result = getResult(connection,is,os,br);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            release(connection,is,os,br);
        }
        System.out.println(result);
        return result;
    }

    public static String getResult(HttpURLConnection connection,InputStream is,
                                 OutputStream os,BufferedReader br) {
        String result = null;
        try {
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // 对输入流对象进行包装:charset根据工作项目组的要求来设置
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                // 循环遍历一行一行读取数据
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return result;
    }

    /**
     * Description: 释放资源
     *
     * @param
     * @param
     * @throws IOException
     */
    public static void release(HttpURLConnection connection,InputStream is,
                               OutputStream os,BufferedReader br) {
        // 关闭资源
        if (null != br) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != os) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != is) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 断开与远程地址url的连接
        connection.disconnect();
    }

    /**
     * 获取连接
     * @param url
     */
    public static HttpURLConnection getConnection(URL url,String method) {
        HttpURLConnection connection = null;
        try {
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod(method);
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);

            if ("POST".equals(method)) {
                // 默认值为：false，当向远程服务器传送数据/写数据时，需要设置为true
                connection.setDoOutput(true);
                // 默认值为：true，当前向远程服务读取数据时，设置为true，该参数可有可无
                connection.setDoInput(true);
                // 设置传入参数的格式:请求参数应该是 name1=value1&name2=value2 的形式。
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                // 设置鉴权信息：Authorization: Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0
                connection.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return connection;
    }
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\n" +
                "    \"username\":\"longxiao\",\n" +
                "    \"password\":\"Lx2622810904,.&\"\n" +
                "}");
        //doPost("https://athena.cashbus.com/rest/login",jsonObject.toJSONString());
        doGet("http://127.0.0.1:8888/v1/test");
    }
}