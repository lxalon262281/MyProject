package com.lx.demo.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *自定义数据类型，并在自定义的数据类型中实现CompareTo方法
 *
 * .自然排序
 * 自然排序要进行一下操作：
 * 1.类中实现 Comparable接口
 * 2.重写Comparable接口中的Compareto方法
 */
class Teacher implements Comparable {
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    int num;

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Teacher(String name,int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "编号：" + num + " 姓名：" + name;
    }

    public int compareTo1(Object o) {
        Teacher ss = (Teacher) o;
        int result = num > ss.num ? 1 : (num == ss.num ? 0 : -1);
        if (result == 0) {
            result = name.compareTo(ss.name);
        }
        return result;
    }

    public int compareTo(Object obj) {
        Teacher t1 = (Teacher) obj;
        int result = num > t1 .num ? 1 : (num == t1.num ? 0 : -1);
        if (result == 0) {
            result = name .compareTo(t1.name);
        }
        return result;
    }
}

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Teacher> treeSet = new TreeSet<Teacher>();
        treeSet.add(new Teacher("zhangsan", 2));
        treeSet.add(new Teacher("lisi", 1));
        treeSet.add(new Teacher("wangwu", 4));
        treeSet.add(new Teacher("mazi", 3));

        System.out.println(treeSet);//直接输出

        Iterator itTSet = treeSet.iterator();//遍历输出
        while(itTSet.hasNext())
            System.out.print(itTSet.next() + "\t");
        System.out.println();
    }
}

