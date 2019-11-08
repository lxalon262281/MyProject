package com.lx.demo;

import java.io.*;

/**
 * 读取文件并统计特定字符，把结果写进文件里
 * 简单写了程序的实现之后也能够回答面试时第二个问题了。
 第二个问题是：如果需要测试这个error统计的程序，应该怎么测？
 当时的回答只有一些基本功能实现层面的回答，自己写了之后才发现其实代码层面有很多可能出问题的地方，
 根据代码实现使用的不同的方法，可能会有很多问题，比如error在文章开头的时候可能第一个字符会读不到，
 比如error后一半在另外一行，比如error在文章末尾，这些情况可能对应不同的问题
 */
public class MessageCollect {

    public static void main(String[] args) {
        MessageCollect messageCollect = new MessageCollect();
        String content = messageCollect.readFile();
        int count = messageCollect.count(content);
        messageCollect.writeMessage(count);

        Integer integer= null;
        Long l = null;
        Double d = null;
        Float f = null;
        Boolean b = null;
        String s = null;
    }

    public String readFile() {
        try {
            File file = new File("");
            if (!file.exists()) {
                file.createNewFile();
            }
           // InputStream ins = new FileInputStream(file);
            //读取文件
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String content = null;
            String str = "";
            while ((str = br.readLine()) != null) {
                content = str;
            }
            System.out.println(content);
            br.close();
            return content;
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    public void writeMessage(int count) {
       try {
           //写进文件里
           File file = new File("");
           FileOutputStream fos = new FileOutputStream(file,false);
           fos.write("错误个数为：".getBytes());
           fos.write(count);
           fos.flush();
           fos.close();

       } catch (Exception e) {

       }

    }

    public int count(String content) {
        //替换掉换行符
        content = content.replaceAll("\n","");

        //统计个数
        String strToFind = "error";
        int index = 0;
        int count = 0;
        int indexx = 0;
        while ((index = content.indexOf(strToFind,indexx)) != -1) {
            indexx = index + strToFind.length();
            count++;
        }

        return count;
    }
}
