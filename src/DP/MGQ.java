package DP;

import utils.MyPrintFunction;

public class MGQ {
    public static int mgq(int n, int np, int[] g, int[] p) {
        int[][] dp = new int[n + 1][np + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= np; j++) {
                if (j < p[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], g[i - 1] + dp[i - 1][j - p[i - 1]]);
            }
        }
        return dp[n][np];
    }

    public static void main(String[] args) {
        int n = 5;
        int w = 10;
        int[] g = {400, 500, 200, 300, 350};
        int[] p = {5, 5, 3, 4, 3};
        System.out.println(mgq(n, w, g, p));
    }
}
