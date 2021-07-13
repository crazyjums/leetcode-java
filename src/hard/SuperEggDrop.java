package hard;

import utils.MyPrintFunction;

import java.util.Arrays;

public class SuperEggDrop {
    public static int superEggDrop(int K, int N) {
        /*
        动态规划求解，dp[N][K]表示有N层楼、K个鸡蛋求得F的值的最小移动次数
        */
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], //和前一次比较，取最小值
                            1 + Math.max(dp[k - 1][j - 1], //鸡蛋碎了，区间应该在[1, k - 1]的闭区间中间，且鸡蛋数减1
                                    dp[i - k][j]) //鸡蛋没有碎，鸡蛋个数保持不变，楼层区间应该在[i - k, i]之间
                    );
                }
            }
        }
        return dp[N][K];
    }


    public static int superEggDrop2(int K, int N) {
        /*
        动态规划求解，dp[N][K]表示有N层楼、K个鸡蛋求得F的值的最小移动次数
        */
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }
        for (int i = 1; i <= K; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                int left = 1;
                int right = i;
                while (left < right) {
                    int mid = left + (right - left + 1) / 2;
                    int breakCount = dp[mid - 1][j - 1]; //如果蛋碎了求F得最小移动次数
                    int notBreakCount = dp[i - mid][j]; //如果蛋没有碎，求F得最小移动次数
                    if (breakCount > notBreakCount) {
                        right = mid - 1; //下一轮搜索区间 is [left, mid - 1]的闭区间
                    } else {
                        left = mid; //下一轮的搜索区间 is [mid, right]的闭区间
                    }
                }
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }



    public static void main(String[] args) {
        double s = System.nanoTime();
        System.out.println(superEggDrop(5, 5000));
        double e = System.nanoTime();
        System.out.println(e - s);

        double s1 = System.nanoTime();
        System.out.println(superEggDrop2(5, 5000));
        double e1 = System.nanoTime();
        System.out.println(e1 - s1);
    }
}
