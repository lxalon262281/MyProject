package com.lx.demo;


import java.util.*;

public class FirstNotRepeatingChar {
    public static char firstNotRepeatChar(String str){
//              256个字母
        char temp = str.charAt(0);
        int[] hashTimes= new int[256];
        for(int i=0;i<str.length();i++){
            hashTimes[str.charAt(i)]++;
        }
        for (int i=0;i<str.length();i++){
            if(hashTimes[str.charAt(i)]==1){
                return str.charAt(i);
            }
        }
        return '\77';
    }

    public static void main(String[] args) {
        System.out.println(firstNotRepeat("aaaaaaaaaaaaaabb"));

    }

    public static String firstNotRepeat(String str){
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            Integer count = map.get(c); //看数目
            if (map.get(c) == null) {
                map.put(c,1);
            } else {
                map.put(c,count + 1);
            }
        }

        StringBuilder sb=new StringBuilder();
        for (Map.Entry<Character,Integer> m: map.entrySet()) {
            sb.append(m.getKey()+"("+m.getValue()+")");
        }
        return sb.toString();
    }

//    private static void sortTreeMap(){
//        Map<String,Integer> map = new HashMap<String,Integer>((k1, k2)->{
//            return k1.compareTo(k2);
//        });
//        map.put("a",2);
//        map.put("c",5);
//        map.put("d",6);
//        map.put("b",1);
//
//        List<Map.Entry<String,Integer>> lstEntry=new ArrayList<>(map.entrySet());
//        Collections.sort(lstEntry,((o1, o2) -> {
//            return o1.getValue().compareTo(o2.getValue());
//        }));
//
//
//    }


}

