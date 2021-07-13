package test;


import java.util.*;

class Animal {
    public void eat() {
        System.out.println("eat");
    }

    public void sleep() {
        System.out.println("sleep");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃肉");
    }

//    public void sleep() {
//        System.out.println("狗站着睡觉");
//    }

    public void eatShit() {
        System.out.println("dog is eating shit...");
    }
}

public class TestDuoTai {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();

        Dog dog1 = new Dog();
        dog1.eatShit();
        Set<Integer> set = new HashSet<>();

    }
}
