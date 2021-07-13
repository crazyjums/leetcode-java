package middle;

import utils.Test;

public class Divide {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;


        int flag = ((long)dividend * divisor < 0) ? -1 : 1;
        long a = dividend>0?dividend:-(long)dividend;
        long b = divisor>0?divisor:-(long)divisor;
//        if (dividend < divisor) return 0;
        long res = 0;

        while (a >= b) {
            long tem = b;
            long count = 1;
            while (a >= tem+tem) {
                count <<= 1;
                tem <<= 1;
            }
            a-=tem;
            res+=count;
        }
        return (int) Math.min(Integer.MAX_VALUE, Math.max(res*flag, Integer.MIN_VALUE));
    }

    public static void main(String[] args) {
        System.out.println(new Divide().divide(Integer.MAX_VALUE, 1)==Integer.MAX_VALUE);

        int a,b,x,y;//非volatile变量
        boolean f;//volatile变量
        a=1;//1
        b=2;//2
        f=false;//3
        x=10;//4
        y=20;//5







    }
}
