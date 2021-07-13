package utils;

import java.lang.reflect.InvocationTargetException;

public class A {
    public int a = 0;

    public A(int a) {
        this.a = a;
    }

    public A() {
    }

    public void fun() {
        System.out.println("A");
    }
    private void testa () {
        System.out.println("aaa");
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        String s = "";
        s += 'c';
        System.out.println(s);
        System.out.println((long)65535*65535);
    }
}
