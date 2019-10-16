package com.lx.IODemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FolderTest {
    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<>();
        List<File>  fileList = getFiles("/Users/src",files);
        System.out.println("fileList size:" + fileList.size());

        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {

                return Long.compare(o1.length(),o2.length());
            }
        });

        for (File file : fileList) {
            System.out.println(file.getName() + "c----- " + file.length());
        }

//        recursiveFiles("/Users/src");

    }


    public static List<File> getFiles(String path,List<File> list) {
        File file = new File(path);
        //ArrayList<File> fileList = new ArrayList<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File f : files) {
                if (f.isDirectory()) {
                    getFiles(f.getPath(),list);
                } else {
                    list.add(f);
                }
            }
        }

        return list;
    }

    /**
     * Xiwi
     * 遍历文件/文件夹 - 函数
     * [String]path        文件路径
     */
    private static void recursiveFiles(String path){

        // 创建 File对象
        File file = new File(path);

        // 取 文件/文件夹
        File files[] = file.listFiles();

        // 对象为空 直接返回
        if(files == null){
            return;
        }

        // 目录下文件
        if(files.length == 0){
            System.out.println(path + "该文件夹下没有文件");
        }

        // 存在文件 遍历 判断
        for (File f : files) {

            // 判断是否为 文件夹
            if(f.isDirectory()){

//                System.out.print("文件夹: ");
//                System.out.println(f.getAbsolutePath());

                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());


                // 判断是否为 文件
            } else if(f.isFile()){

                System.out.print("文件: ");
                System.out.println(f.getAbsolutePath());

            } else {
                System.out.print("未知错误文件");
            }

        }

    }

}
