package com.lx.demo.arithmetic;

import java.io.File;
import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        File f = new File("/Users/alon/test的副本.txt");
        if(!f.exists()) {
            return;
        }

        try{
            Scanner scanner = new Scanner(f);
            HashMap<String,Integer> map = new HashMap<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] lineWords = line.trim().split("[，。？,.? ！!]");

                Set<String> set = map.keySet();
                for(int i = 0; i < lineWords.length; i++) {
                    if(!set.contains(lineWords[i])) {
                        map.put(lineWords[i],1);
                    } else {
                        int num = map.get(lineWords[i]);
                        num++;
                        map.put(lineWords[i],num);
                    }
                }
            }

            Iterator<String> it = map.keySet().iterator();

            while(it.hasNext()) {
                String word = it.next();
                int count = map.get(word);
                System.out.println("单词: " + word + " 出现的次数为 ：" + count);
            }
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    public static int count() {
        return 0;
    }
}
