package com.lx.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
    public static void main(String[] args) {
//        List<Person> list=new ArrayList<Person>();
//        Person test1=new Person(66,"李四");
//        Person test2=new Person(29,"王五");
//        Person test3=new Person(28,"赵六");
//        Person test4=new Person(20,"钱三");
//        list.add(test4);
//        list.add(test3);
//        list.add(test2);
//        list.add(test1);
//        Collections.sort(list);
//        for(Object s:list){
//            System.out.println(s);
//        }

//        List<PersonB> list=new ArrayList<PersonB>();
//        PersonB test1=new PersonB(66,"李四");
//        PersonB test2=new PersonB(29,"王五");
//        PersonB test3=new PersonB(28,"赵六");
//        PersonB test4=new PersonB(20,"钱三");
//        list.add(test4);
//        list.add(test3);
//        list.add(test2);
//        list.add(test1);
//        Collections.sort(list);
//        for(Object s:list){
//            System.out.println(s);
//        }

    }

    public void test2(){
        List<PersonB> list=new ArrayList<PersonB>();
        PersonB test1=new PersonB(69,"李四");
        PersonB test2=new PersonB(29,"王五");
        PersonB test3=new PersonB(28,"赵六");
        PersonB test4=new PersonB(20,"钱三");
        list.add(test4);
        list.add(test3);
        list.add(test2);
        list.add(test1);
        Collections.sort(list,new Comparator<PersonB>(){
            @Override
            public int compare(PersonB o1, PersonB o2) {
                if(o1.age==o2.age&&o1.name==o2.name){
                    return 0;
                }else if(o1.age>o2.age){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for(Object s:list){
            System.out.println(s);
        }
    }
}
