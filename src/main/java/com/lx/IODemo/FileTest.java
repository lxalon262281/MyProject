package com.lx.IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTest {
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

//        int read = fins.read();
//
//        while (read > 0) {
//            System.out.print((char)read);
//            read = fins.read();
//        }

        byte[] bytes = new byte[102];

        int len = 0;

        while ((len = fins.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
        fins.close();

        String s = new String(bytes,0,bytes.length);
        s += "hhh";

        File file1 = new File("/Users/资料/test2.txt");

        FileOutputStream fos = new FileOutputStream(file1);
        fos.write(s.getBytes());
        fos.close();;

    }
}
