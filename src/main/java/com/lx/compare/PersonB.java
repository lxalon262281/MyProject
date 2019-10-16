package com.lx.compare;

public class PersonB {

    public int age;    //年龄
    public String name;  //姓名

    //get、set方法
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PersonB(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
    //实现Comparable接口必须实现compareTo方法

    public PersonB() {
        super();
        // TODO Auto-generated constructor stub
    }

}
