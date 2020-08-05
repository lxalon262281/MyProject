package com.lx.demo.str;

import java.util.*;

/**
 *  统计字符串每个字符出现的次数，并根据出现的次数排序
 */
public class FindCharNumber {
    public static void main(String[] args) {
        String str = "asdzxcfffaassddxxcc aass  ddd";
        String str2 = "asdfhellozbgdnejhellomddnhhello   hell ysbdh hel 111hhhhello111";
        System.out.println(solution2(str2,"hello"));
        HashMap map = solution(str);
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<String,Integer> entry : list) {
            String key = entry.getKey();
            System.out.println(key + "----" + map.get(key));
        }
    }

    public static HashMap solution(String str) {
        if (str.length() == 0) {
            return null;
        }
        int len = str.length();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0 ; i < len; i++) {
            char c = str.charAt(i);

            if (map.isEmpty() || !map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c),1);
            } else {
                int number = map.get((String.valueOf(c)));
                map.put(String.valueOf(c), number + 1);
            }
        }
        return map;
    }

    /**
     * 统计字符串出现的次数。
     * @param content
     * @param targetstr
     * @return
     */
    public static final int solution2(String content,String targetstr) {
        if (content.length() == 0) {
            return 0;
        }
        int index;
        int count = 0;
        while (content.length() > 0 && (index = content.indexOf(targetstr))!= -1) {
            count++;
            content = content.substring(index +1,content.length() -1);
        }
        return count;
    }

}
