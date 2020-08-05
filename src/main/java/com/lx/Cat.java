package com.lx;

public class Cat extends Animal{
    public void Cat() {

    }
//    public void Animal() {
//        System.out.println("子类");
//    }
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.Animal();
        cat.Animal("cat");

        StringBuffer sb = new StringBuffer("qwertyu");
        sb.reverse();
        System.out.println(sb.toString());

        String s = "";
    }


}
