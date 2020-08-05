package com.lx.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.misc.IOUtils;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HttpUtils {
    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static RequestConfig requestConfig = null;
    private static HttpClientBuilder httpBuilder = null;

    private static int MAXCONNECTION = 10;

    private static int DEFAULTMAXCONNECTION = 5;

    private static String IP = "cnivi.com.cn";
    private static int PORT = 80;

    static {
        //设置http的状态参数
        requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();

        HttpHost target = new HttpHost(IP, PORT);
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAXCONNECTION);//客户端总并行链接最大数
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);//每个主机的最大并行链接数
        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);
        httpBuilder = HttpClients.custom();
        httpBuilder.setConnectionManager(connectionManager);
    }


    public static CloseableHttpClient getConnection() {
        CloseableHttpClient httpClient = httpBuilder.build();
        return httpClient;
    }

    /**
     * 发送 get请求
     */
    public void get() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            // 创建httpget.
            HttpGet httpget = new HttpGet("http://www.baidu.com/");
            System.out.println("executing request " + httpget.getURI());
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                System.out.println("--------------------------------------");
                // 打印响应状态
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    System.out.println("Response content: " + EntityUtils.toString(entity));
                }
                System.out.println("------------------------------------");
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果
     */
    public void post() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceJ.action");

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json; charset=utf-8");

        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("type", "house"));
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            httppost.setHeader("Content-Type", "application/json");
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    System.out.println("--------------------------------------");
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                    System.out.println("--------------------------------------");
                }
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if ("post".equals(method)) {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        } else if ("get".equals(method)) {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        }
        return reqMethod;
    }

    public static void main(String args[]) throws IOException {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("username", "longxiao");
//        map.put("password", "Lx2622810904,.&");
//
//        HttpClient client = getConnection();
//        HttpUriRequest post = getRequestMethod(map, "https://athena.cashbus.com/rest/login", "post");
//        HttpResponse response = client.execute(post);
//
//        if (response.getStatusLine().getStatusCode() == 200) {
//            HttpEntity entity = response.getEntity();
//            String message = EntityUtils.toString(entity, "utf-8");
//            System.out.println(message);
//        } else {
//            System.out.println("请求失败");
//        }
       try {
           func();
       } catch (Exception e) {
           e.getStackTrace();
       }

    }

    public static void func() throws Exception {
       for (int id = 1000; id < 2000; id++) {
           try {
               HttpClient client = HttpClients.createDefault();

               HttpGet httpGet = new HttpGet("https://gate.lagou.com/v1/neirong/kaiwu/getCourseLessonDetail?lessonId=" + id);
               httpGet.addHeader("cookie", "_ga=GA1.2.999643115.1550409501; user_trace_token=20190217211842-8bd832a1-32b6-11e9-8212-5254005c3644; LGUID=20190217211842-8bd83590-32b6-11e9-8212-5254005c3644; _putrc=7B16CC75A96D3702; login=true; unick=%E8%94%A1%E5%87%A1; X_MIDDLE_TOKEN=59515dc0ff9ded43acebb465a1322d04; sensorsdata2015session=%7B%7D; LG_HAS_LOGIN=1; SESSION=af22530a-8c5d-473c-a1f3-5ef4e0aefdc8; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1593869218; _gid=GA1.2.381499924.1593869218; index_location_city=%E5%B9%BF%E5%B7%9E; LG_LOGIN_USER_ID=79f3ab7e508ac1ab7f192197c4a2c7e2fc64e3ed78f1b2b4; privacyPolicyPopup=false; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1593869240; LGRID=20200704212737-7fee9341-cb6d-4995-b63f-0a0aec6eb730; gate_login_token=aea0a3f7a098d0e6cde126fb9d7788af51ec8fe383b1ef3e; X_HTTP_TOKEN=659bc3351c610797952968395123e5f8028cf916bd; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22355048%22%2C%22%24device_id%22%3A%22168fb9bbcb7782-0cd9233083a6f6-5c11301c-1327104-168fb9bbcb89c1%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_referrer%22%3A%22%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24os%22%3A%22Windows%22%2C%22%24browser%22%3A%22Chrome%22%2C%22%24browser_version%22%3A%2281.0.4044.1381c-1327104-168fb9bbcb89c1%22%7D");
               httpGet.addHeader("x-l-req-header", "{deviceType:1}");
               HttpResponse httpResponse = client.execute(httpGet);
               HttpEntity entity = httpResponse.getEntity();

               InputStream inputStream = entity.getContent();
//        byte[] bytes = new byte[0];
//        bytes = new byte[inputStream.available()];
//        inputStream.read(bytes);
//        String str = new String(bytes);
               String result = new BufferedReader(new InputStreamReader(inputStream))
                       .lines().collect(Collectors.joining(System.lineSeparator()));

//        String content = IOUtils.toString(inputStream);
               System.out.println(result);
//        InputStream inputStream = entity.getContent();
//        String content = IOUtils.toString(inputStream);
               JSONObject contentObj = JSONObject.parseObject(result);
//content节点
               JSONObject content1 = contentObj.getJSONObject("content");
               if (content1 == null) {
                   continue;
               }

               String title = content1.getString("theme");//标题
// 视频地址
               JSONObject videoJSON = content1.getJSONObject("videoMedia");
               String videoUrl = videoJSON.getString("fileUrl");

//音频地址
               JSONObject audioJSON = content1.getJSONObject("audioMedia");
               String audioUrl = audioJSON.getString("fileUrl");

//真实有用的内容
               String realContent = content1.getString("textContent");
               System.out.println(title);

               String courseId = content1.getString("courseId");

               String path = "/Volumes/资料/拉钩学习资料/";
               File file = new File(path + courseId);
               if (!file.exists()) {
                   file.mkdir();
               }

                PrintWriter printWriter = new PrintWriter("/Volumes/资料/拉钩学习资料/"+ courseId + "/+" + title + ".md");
                printWriter.write(title);
                printWriter.write(videoUrl);
                printWriter.write(audioUrl);
                printWriter.write(realContent);
                printWriter.flush();
                printWriter.close();
           } catch (Exception e) {
               e.getMessage();
           }
       }
    }


}
