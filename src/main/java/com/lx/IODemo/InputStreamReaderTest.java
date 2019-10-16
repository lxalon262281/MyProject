package com.lx.IODemo;

import java.io.*;

public class InputStreamReaderTest {
    public static void main(String[] args) throws Exception{
        //需要操作的对象（文件）的路径，
        String path = "/Users/资料/test.txt";
        //通过File来拿到我们要操作的对象
        File file = new File(path);

        //文件不存在则创建一个文件
        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fins = new FileInputStream(file);
        FileReader reader = new FileReader(file);

        BufferedReader bfReader = new BufferedReader(reader);
        InputStreamReader isRead = new InputStreamReader(fins,"GBK");

        char[] chars = new char[64];

        String line = "";
        String content = "";
        while ((line = bfReader.readLine()) != null) {
            //content = new String(chars,0,len);
            content = line;
        }

//        int result = isRead.read(chars);

        System.out.println(content);

        System.out.println(line);

        FileOutputStream fos = new FileOutputStream(file);
        FileWriter writer = new FileWriter(file);
        OutputStreamWriter osWriter = new OutputStreamWriter(fos);
        BufferedWriter bfw = new BufferedWriter(writer);



    }
}
