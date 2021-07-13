package utils;

public class Test2 extends Test{
    public Test2() {
        System.out.println("Test2这是构造函数");
    }
    {
        System.out.println("Test2这是构造代码块");
    }
    static {
        System.out.println("Test2这是静态代码块");
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
    }
}
