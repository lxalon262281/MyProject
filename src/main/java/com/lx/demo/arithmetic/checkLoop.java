package com.lx.demo.arithmetic;

import java.util.*;

public class checkLoop {
    static String x = null;
    public static void main(String[] args) {
//        String [] str = {"gj","jl","dg","ad","gg"};
//        checkLoop(str, 0);
//        System.out.println(x);
        String[] s = new String[]{"abc","dda","bcd","cab"};
//      String[] s = {"gwj","jcl","dlg","akd","qag"};
        System.out.println(strOrEnd(s));

    }

//    public static void checkLoop(String[] arr,int k) {
//        if(arr.length == 0) {
//            x = Arrays.toString(arr);
//            return;
//        }
//
//        for(int i = k; i < arr.length; ++i) {
//            if(k > 0 && judge(arr[k -1],arr[i])) {
//                swap(arr,k,i);
//                checkLoop(arr,k + 1);
//                swap(arr,k,i);
//            } else if(k == 0) {
//                swap(arr,k,i);
//                checkLoop(arr,k + 1);
//                swap(arr,k,i);
//            }
//        }
//    }
//    public static void swap(String[] arr, int k,int i) {
//        String temp = arr[k];
//        arr[k] = arr[i];
//        arr[i] = temp;
//    }
//    public static boolean judge(String s1, String s2) {
//        if(s1.charAt(s1.length() - 1) == s2.charAt(0)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    private static int isLink(String[] s) {
//        StringBuffer sb=new StringBuffer();
//        for(String str:s){
//            sb.append(str.charAt(0));
//            sb.append(str.charAt(str.length()-1));
//        }
//        List<String> list=listAll(Arrays.asList(sb.toString().split("")),"");
//        for(String str:list){
//            if(check(str)){
//                return 1;
//            }
//        }
//        return 0;
//    }
//
//    private static boolean check(String str) {
//        for(int i=1;i<=str.length()-3;i=i+2){
//            if(str.charAt(i)!=str.charAt(i+1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static List<String> listAll(List<String> candidate, String prefix) {
//        List<String> list= new ArrayList<String>();
//        if(candidate.isEmpty()) {
//            list.add(prefix);
//        }else {
//            for (int i = 0; i < candidate.size(); i++) {
//                List temp = new LinkedList(candidate);//为了方便提取后删除每个元素
//                List<String> results=listAll(temp, prefix + temp.remove(i));
//                for(String s:results){
//                    list.add(s);
//                }
//            }
//        }
//        return list;
//    }

    private static boolean strOrEnd(String[] strings) {
        StringBuilder stringBuilder = new StringBuilder();//用于保存字符串的首位字符
        for (int i = 0; i < strings.length; i++) {
            char start = strings[i].charAt(0);
            char end = strings[i].charAt(strings[i].length() - 1);
            stringBuilder.append(start).append(end);
        }
        char[] chars = stringBuilder.toString().toCharArray();//将字符串转换为字符数组
        Map<Character, Integer> map = new HashMap<>();//用于保存字符出现的个数
        for (int i = 0; i < chars.length; i++) {
            char key = chars[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }

        Set<Map.Entry<Character,Integer>> set = map.entrySet();
        for (Map.Entry<Character,Integer> entry : set) {
            int val = entry.getValue();
            if (val % 2 == 1) {
                return false;
            }
        }

        Collection collection = map.values();//遍历map值集
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            if (i % 2 != 0)//如果有一个不是出现偶数次,则说明不能组成环
                return false;
        }
        return true;
    }

}
