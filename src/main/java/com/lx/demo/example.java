package com.lx.demo;

import java.util.*;


/**
 * 使用HashMap的key存储数字字串，value存字串长度，考虑到HashMap存储无序，故改为LInkedHashMap,然后根据Map的value值排序，取出value值最大的map元素并输出，但是忽略一个特殊情况，就是当最大子串有若干个且相同，则map由于key不能重复，只会存储一个，故有缺陷

 思路：先把字符串中的字母都变为空格，用split方法按照空格拼接成一个数组，把这个数组遍历，拿出来每个值
 设置一个初始值 max=0，认为这个max是最大的，数组里每一个的length()都跟这个max比较，如果比max大，就赋值给max
 */
public class example {

    public static void main(String[] args) {

        String str ="abcdefghijklmn12345ed125ss123058789";
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            List<String> list = new ArrayList<String>();
            String s =	sc.nextLine();
            String s1= s.replaceAll("[a-z]", " ");

            String[] s2 =s1.split(" ");

            for(int i=0;i<s2.length;i++) {
                if(s2[i].length()!=0) {
                    if(s2[i].charAt(0)!=' ') {
                        list.add(s2[i]);
                    }
                }
            }

            //System.out.print(list.size());
            List<Integer> index=new ArrayList<Integer>();
            int max=0;
            for (int k=1;k<list.size();k++) {
                if(list.get(k).length()>list.get(max).length()) {
                    max=k;
                    index.clear();
                }else if(list.get(k).length()==list.get(max).length()) {
                    index.add(k);
                }
            }
            index.add(max);

            System.out.println("最大的数包括： ");
            for(int i = 0;i<index.size();i++){
                System.out.println(list.get(index.get(i))+" ");
            }
            System.out.println();
        }
    }

//    public static int Continumax(String intputStr, StringBuffer outputStr) {
//        List<String> digitList = new ArrayList<String>();//转化为list方便操作
//        Pattern pattern = Pattern.compile("\\d+");
//        Matcher matcher = pattern.matcher(intputStr);
//        while (matcher.find()) {
//            digitList.add(matcher.group(0));
//        }
//        if (digitList.isEmpty()) {
//            System.out.println("没有数字串！");
//            return 0;
//        }
//        for (int i = digitList.size() - 1; i >= 0; i--) {
//            if (!isContinue(digitList.get(i).toCharArray())) {
//                digitList.remove(i);
//            }
//        }
//        Collections.sort(digitList, new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                int thisLength = String.valueOf(o1).length();
//                int otherLength = String.valueOf(o2).length();
//                return thisLength - otherLength;
//            }
//        });
//        System.out.println("最大连续数字串为：" + digitList.get(digitList.size() - 1) + "其长度为：" + digitList.get(digitList.size() - 1).length());
//        return digitList.get(digitList.size() - 1).length();
//    }
//
//    private static boolean isContinue(char[] array) {
//        return Math.abs(array[array.length - 1] - array[0]) == array.length - 1;
//    }
//
//    public static void main(String[] arg) {
//        Continumax("abcdefghijk123456ss54321", null);
//    }
}

