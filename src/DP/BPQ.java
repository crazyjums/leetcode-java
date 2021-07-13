package DP;

public class BPQ {
    public static int bpq(int[] w, int[] v, int C) {
        int n = w.length;
        int[][] dp = new int[n][C];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < C; j++) {
                if (w[i] <= j) { //选   ”=“号不能省略
                    dp[i][j] = Math.max(dp[i - 1][j - w[i]] +v[i], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n - 1][C - 1];
    }

    public static void main(String[] args) {
        int[] w = {4,3,3,2};
        int[] v = {2,5,4,6};
        int C = 6;
        int res = bpq(w, v, C);
        System.out.println(res);
    }
}
