package DP;

import java.util.Arrays;

/**
 * 背包问题：
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，
 * 最多能装的价值是多少？
 */
public class BackpagQuestion {
    /**
     *
     * @param n 物体的数量
     * @param w 背包所能放物体的最大重量
     * @param wt 每件物体的重量
     * @param val 每件物体的价值
     * @return
     */
    public int recursion(int n, int w, int[] wt, int[] val) {
        if (w == 0 || n == 0)
            return 0;
        if (wt[n - 1] < w) //放
            return Math.max(recursion(n - 1, w, wt, val), recursion(n - 1, w - wt[n - 1], wt, val) + val[n - 1]);
        else
            return recursion(n - 1, w, wt, val);
    }
    /**
     *
     * @param n 物体的数量
     * @param w 背包所能放物体的最大重量
     * @param wt 每件物体的重量
     * @param val 每件物体的价值
     * @return
     */
    public int dpSolution(int n, int w, int[] wt, int[] val) {
        int[][] res = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j >= wt[i - 1])//背包所能承受的重量大于物体的重量，就放进去
                    res[i][j] = Math.max(res[i - 1][j], res[i - 1][j - wt[i - 1]] + val[i - 1]);
                else
                    res[i][j] = res[i -1][j];
            }
        }
        return res[n][w];
    }
    /**
     *
     * @param n 物体的数量
     * @param w 背包所能放物体的最大重量
     * @param wt 每件物体的重量
     * @param val 每件物体的价值
     * @return
     */
    public int dpSolution2(int n, int w, int[] wt, int[] val){
        int [] dp=new int[w+1];
        for (int i = 1; i < n+1; i++) {
            for (int j=w;j>0;j--) {
                if (j>=wt[i-1])
                    dp[j] = Math.max(dp[j],dp[j-wt[i-1]]+val[i-1]);
            }
        }
        return dp[w];
    }


    public static void main(String[] args) {
        int n = 4;
        int w = 6;
        int[] wt = {4,3,3,2};
        int[] val = {2,5,4,6};
        BackpagQuestion backpagQuestion = new BackpagQuestion();
        int res = backpagQuestion.recursion(n, w, wt, val);
        System.out.println("递归求解：" + res);
        System.out.println("dp求解：" + backpagQuestion.dpSolution(n, w, wt, val));
        System.out.println("第二种解法："+backpagQuestion.dpSolution2(n,w,wt,val));
    }
}
