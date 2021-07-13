package secondTime;

public class Fibonacci {
    public static int Fibonacci(int n) {
        if (n<=1)
            return n;
        int m0=0;
        int m1=1;
        int m2 = m0+m1;
        for(int i=2;i<=n;i++){
            m2=m1+m0;
            m0=m1;
            m1=m2;
        }
        return m2;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
}
