package simple;

public class GreatestCommonDivisor {
    //暴力破解法
    public int gcd1(int a,int b){
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        if (big%small==0)
            return small;
        for (int i = (int)small/2; i >=1; i--) {
            if (a%i==0 && b%i==0)
                return i;
        }
        return 1;
    }

    /**
     * 辗转相除法
     * 欧几里得认为，整数a和b（a>b）的最大公约数，等于a除b的余数c和b的最大公约数，以此类推，
     * 然后c和b的最大公约数等于c%b=d和b的最大公约数......
     * @param a
     * @param b
     * @return
     */
    public int gcd2(int a,int b){
        if (a==b)
            return a;
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        if (big%small==0)
            return small;
        return gcd2(big%small,small);
    }

    /**
     * 由于在gcd2()中，数据取模运算比较消耗算法性能，所以这里还可以进行优化
     * 使用《九章算术》中的相关知识：a和b（a>b）的最大公约数等于a-b=c和b(b>c)的最大公约数，
     * c和b的最大公约数等于b-c=d和c的最大公约数，以此类推......
     * @param a
     * @param b
     * @return
     */
    public int gcd3(int a,int b){
        if (a==b)
            return a;
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        return gcd3(big-small,small);
    }

    /**
     * 对于gcd3()还可以进一步进行优化，使用位移操作代替取模，加快算法性能
     * （1）当a和b都是偶数时，则gcd4(a>>1,b>>1)
     * （2）当a是奇数、b是偶数时，则gcd4(a,b>>1)
     * （3）当a时偶数、b时奇数时，则gcd4(a>>1,b)
     * （4）当a和b(a>b)都是奇数时，则gcd4(a-b,b)
     * @param a
     * @param b
     * @return
     */
    public int gcd4(int a,int b){
        if (a==b)
            return a;
        if ((a&1)==0 && (b&1)==0)
            return gcd4(a>>1,b>>1);
        else if ((a&1)==0 && (b&1)!=0)
            return gcd4(a>>1,b);
        else if ((a&1)!=0&&(b&1)==0)
            return gcd4(a,b>>1);
        else
            return gcd4(Math.max(a,b)-Math.min(a,b),Math.min(a,b));
    }


    public static void main(String[] args) {
        int a = 10000;
        int b = 95;
        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();

        System.out.println(greatestCommonDivisor.gcd1(a,b));
        System.out.println(greatestCommonDivisor.gcd2(a,b));
        System.out.println(greatestCommonDivisor.gcd3(a,b));
        System.out.println(greatestCommonDivisor.gcd4(a,b));
    }
}
