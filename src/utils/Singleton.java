package utils;

import java.util.PrimitiveIterator;

public class Singleton {

    private Singleton(){}

    private static Singleton singleton;
    public static Singleton getInstance(){
        if (singleton==null)
            singleton = new Singleton();
        return singleton;
    }

    public static void main(String[] args) {
        Person p;
        p=Person.getInstance();
        System.out.println(p);
        Person person=Person.getInstance();
        System.out.println(person);
//        Singleton singleton;
//        singleton = Singleton.getInstance();
//        System.out.println(singleton);
//        Singleton singleton1;
//        singleton1 = Singleton.getInstance();
//        System.out.println(singleton1);
    }
}
