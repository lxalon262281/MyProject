package com.lx.demo.collection;

import java.util.*;

/**
 * Set的用法
 * TreeSet自动排序
 * HashSet只作为存储的集合，是无序的
 * LinkedHashSet的主要功能用于保证FIFO即有序的集合(先进先出)
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();
        hashSet.add("abc");
        hashSet.add("xyz");
        hashSet.add("rst");
        System.out.println(hashSet);//输出结果为：[rst, abc, xyz]

        linkedHashSet.add("abc");
        linkedHashSet.add("xyz");
        linkedHashSet.add("rst");
        System.out.println(linkedHashSet);//输出结果为：[abc, xyz, rst]

        treeSet.add("abc");
        treeSet.add("xyz");
        treeSet.add("rst");
        System.out.println(treeSet);//输出结果为：[abc, rst, xyz]

        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
