package simple;

/**
 * 求n的阶乘  n!= 1 + 2 + ... + n
 */
public class Factorial {
    public int nSum(int n){
        if ((n&1)!=0)//偶数
            return (n/2)*(n+1) + ((int)n/2+1);
        return (n/2)*(n+1);
    }

    public static void main(String[] args) {
        int n=11;
        Factorial factorial = new Factorial();
        System.out.println(factorial.nSum(n));
    }
}
