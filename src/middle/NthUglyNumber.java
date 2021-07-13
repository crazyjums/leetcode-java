package middle;

import java.util.Arrays;

public class NthUglyNumber {
    public int uglyNumber(int n){
        int []dp =new int[n];
        int a=0,b=0,c=0;
        dp[0]=1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[a]*2,dp[b]*3),dp[c]*5);
            if (dp[i]==dp[a]*2)a++;
            if (dp[i]==dp[b]*3)b++;
            if (dp[i]==dp[c]*5)c++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n=10;
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        int res = nthUglyNumber.uglyNumber(n);
        System.out.println(res);
    }
}
