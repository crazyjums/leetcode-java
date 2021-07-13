package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Fib {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("A");
        StringBuffer sb2 = new StringBuffer("B");

        op(sb,sb2);
        System.out.println(sb);
        System.out.println(sb2);


        Fib fib = new Fib();
        System.out.println(fib.fib(5));
    }

    public static void op(StringBuffer a,StringBuffer b){
        a.append(b);
        b=a;
    }

    public int fib(int n){
        if (n<=1){
            return n;
        }
        int[] res= new int[n+1] ;
        res[0]=0;
        res[1]=1;
        for (int i = 2; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2])%1000000007;
        }
        System.out.println(Arrays.toString(res));
        return res[n];
    }
}
