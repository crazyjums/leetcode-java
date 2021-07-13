package middle;

import java.util.Arrays;

public class CuttingRope {
    public int cuttingRope(int n) {
        if (n < 0) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;//f(1) //dp[i]表示第长度为i的绳子被分割后乘积的最大值
//        dp[1] = 1;//f(2)
//        dp[2] = 2;//f(3)
//        dp[3] = 3;
//        int max = 0;
//        for (int i = 4; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                int t = dp[j] * dp[i - j];
//                if (t > max) {
//                    max = t;
//
//                }
//                dp[i] = max;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return dp[n];

//        int b = n % 3;
//        int a = (int)n / 3;
//        if (b == 0)
//            return (int)Math.pow(3.0, a);
//        else if (b == 1)
//            return (int)Math.pow(3.0, a - 1) * 4;
//        else
//            return (int)Math.pow(3.0, a) * 2;


        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return res * n;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new CuttingRope().cuttingRope(n));
        System.out.println(Math.pow(3,2));
    }

}
