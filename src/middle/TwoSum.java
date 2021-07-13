package middle;

import utils.MyPrintFunction;

public class TwoSum {
    public static double[] towsum(int n){
        /**
         * 假设F[n,s]表示有n个骰子能够凑成点数为s的概率，则
         *  - n=1时，F[n,s]=1/6,s=1,2,3,4,5,6
         *  - n>1时，F[n,s]=F[n-1,s-1]+F[n-1,s-2]+F[n-1,s-3]+F[n-1,s-4]+F[n-1,s-5]+F[n-1,s-6]
         *
         *  使用动态规划解题：
         *    1. 确定二维数组的含义；假设F[n,s]表示有n个骰子能够凑成点数为s的概率
         *    2. 状态转移方程：
         *      - n=1时，F[n,s]=1/6,s=1,2,3,4,5,6
         *      - n>1时，F[n,s]=F[n-1,s-1]+F[n-1,s-2]+F[n-1,s-3]+F[n-1,s-4]+F[n-1,s-5]+F[n-1,s-6]
         *    3. 初始状态：F[1,s]=1/6,s=1,2,3,4,5,6
         *
         */
        int [][] f = new int[n+1][6*n+1];
        // 只有一个骰子时，所有概率相等
        for (int i = 1; i <= 6; i++) {
            f[1][i]=1;
        }
        //两个及以上的骰子的概率
        for (int i = 1; i <= n; i++) {//i表示多少个骰子对应的所有点数的概率
            for (int j = i; j <= 6*i; j++) {//j表示i个骰子对应的点数可能是j
                for (int k = 1; k < 7; k++) {//表示一个骰子的点数
                    if (j>=k)//当有i个骰子时，不能有的点数是比骰子个数少的点数，比如：有三个骰子，那么最小的点数就是3，不能有1或者2
                        f[i][j]+=f[i-1][j-k];
                }
            }
        }
        double []res = new double[5*n+1];
        for (int i = n; i < 6*n+1; i++) {
            res[i-n]=f[n][i]/Math.pow(6,n);
        }

        return res;
    }

    public static void main(String[] args) {
        int n=2;
        double[] res = towsum(n);
        MyPrintFunction.print(res);
    }
}
