package com.lx;

import java.io.File;
import java.util.*;

public class ModeA {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abcd";
        String s3 = "zbcde";
        System.out.println(s1.hashCode() + "-----" + s2.hashCode() + "----" + s3.hashCode());
        //File file = new File();

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        ListIterator<String> it = list.listIterator();
//
//        while (it.hasNext()) {
//            try {
//                String s = it.next();
//                if (s.equals("b")) {
//                    list.add("b2");
//                }
//                System.out.println(s);
//            } catch (Exception e) {
//                e.getMessage();
//            }
//        }

        Vector<String> vector = new Vector<>();
        vector.add("aa");
        vector.add("bb");
        vector.add("cc");
        vector.add("dd");
        vector.addElement("ee");
        Enumeration<String> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

//        for (int i = 0; i < vector.size();i++ ) {
//            System.out.println(vector.get(i));
//        }

        String[] list1 = list.toArray(new String[list.size()]);
        List<String> list2 = Arrays.asList(list1);
        System.out.println(list2);
    }
}
