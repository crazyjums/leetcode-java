package DP;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。
 * 参与挖矿工人的总数是10人。每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。
 * 要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
 */
public class MiningGoldQuestion {
    public static void main(String[] args) {
//        int n = 5;
//        int w = 10;
//        int[] g = {400, 500, 200, 300, 350};
//        int[] p = {5, 5, 3, 4, 3};
//        MiningGoldQuestion miningGoldQuestion = new MiningGoldQuestion();
//        int res = miningGoldQuestion.greatestMiningGoldValue(n, w, g, p);
//        System.out.println(res);

//        int res2 = miningGoldQuestion.greatestMiningGoldValue2(n,w,g,p);
//        System.out.println(res2);

//        int res3 = miningGoldQuestion.greatestMiningGoldValue2(n, w, g, p);
//        System.out.println(res3);
        int t = 100;
        int n = 5;
        int[] pn = {77, 22, 29, 50, 99};
        int[] wn = {92, 22, 36, 46, 90};
        System.out.println(getAns(t, n, pn, wn));
    }

    //递归实现
    public static int greatestMiningGoldValue(int n, int w, int[] g, int[] p) {
        if (w == 0 || n == 0)
            return 0;
        if (w < p[n - 1]) //如果当前的工人数小于需要开采当前矿所需的人数，则不开采
            return greatestMiningGoldValue(n - 1, w, g, p);
        return Math.max(greatestMiningGoldValue(n - 1, w, g, p), g[n - 1] + greatestMiningGoldValue(n - 1, w - p[n - 1], g, p));
    }

    //自底向上求解
    public static int greatestMiningGoldValue2(int n, int w, int[] g, int[] p) {
        int[][] miningArray = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1])
                    miningArray[i][j] = miningArray[i - 1][j];
                else
                    miningArray[i][j] = Math.max(miningArray[i - 1][j], miningArray[i - 1][j - p[i - 1]] + g[i - 1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(miningArray[i][j] + " ");
            }
            System.out.println();
        }

        return miningArray[n][w];
    }

    public static int getAns(int t, int n, int[] pn, int[] wn) {
        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1;  i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                if (j >= pn[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - pn[i - 1]] + wn[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][t];
    }

    public static int getAns2() {
        Scanner sc = new Scanner(System.in);
        String tem = sc.nextLine();
        String[] tems = tem.substring(1, tem.length() - 1).split(",");
        int[] nums = new int[tems.length];
        for (int i = 0; i < tems.length; i++) {
            nums[i] = Integer.parseInt(tems[i]);
        }

        List<Integer> res = getNumbers(nums);
        int ans = 0;
        for (int each : res) {
            if (each % 7 == 0)
                ans++;
        }
        return ans;
    }

    public static List<Integer> getNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[nums.length];
        dfs(res, path, used, nums);
        return res;
    }

    private static void dfs(List<Integer> res, StringBuilder path, boolean[] used, int[] nums) {
        if (path.length() == nums.length) {
            res.add(Integer.parseInt(path.toString()));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.append(nums[i]);
                dfs(res, path, used, nums);
                used[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }


    public int greatestMiningGoldValue3(int n, int w, int[] g, int[] p) {
        int[] maxMiningGold = new int[w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = w; j >= 0; j--) {
                if (j >= p[i - 1])
                    maxMiningGold[j] = Math.max(maxMiningGold[j], maxMiningGold[j - p[i - 1]] + g[i - 1]);
            }
        }
        System.out.println(Arrays.toString(maxMiningGold));
        return maxMiningGold[w];
    }
}
