package utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class B  extends  A{

    public int a = 1;

    public B() {
    }

    public B(int a) {
        this.a = a;
    }

    public void fun() {
        System.out.println("fun");
    }
    private void testb () {
        System.out.println("testb");
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException {
        B classA = new B();
//        Class b = B.class;
//        Class b = classA.getClass();
        Class b = Class.forName("utils.B");
        Constructor[] constructors = b.getConstructors();
        Constructor[] constructors1 = b.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));
        System.out.println(Arrays.toString(constructors1));
    }
}
