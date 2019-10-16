package com.lx.compare;

public class Person implements Comparable<Person> {

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
    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
    //实现Comparable接口必须实现compareTo方法
    @Override
    public  int compareTo(Person o) {
        if(this.age==o.age&&this.name==o.name){
            return 0;
        }else if(this.age>o.age){
            System.out.println("this.age:"+this.age+"o.age:"+o.age);
            return 1;
        }else{
            return -1;
        }
    }
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

}
