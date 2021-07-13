package middle;

import utils.MyPrintFunction;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        /**
         * 动态规划步骤：
         *   1. 明确dp table的定义
         *   2. 确定初始状态： base case
         *   3. 定义状态转移方程
         *   4. 定义状态转移方程在不同的状态下的选择
         *
         *
         *   以下面的题目为例：
         *   当需要我确定第i元所需要的硬币总数时，我们只需要在第i-1元所需最少硬币数的基础上再选1个就够了，
         *   1. 明确dp table的定义：dp[i]表示凑i元钱所需要的最少硬币数
         *   2. 初始状态： dp[0]=0：很显然，当总额是0元时，只需要0个硬币
         *   3. 定义状态转移方程
         *     - dp[i] = min(dp[i-coin]+1)，coin属于coins
         *   4. 不同状态下的选择
         *     - 当i==0时，需要0个硬币
         *     - 当i<0时，需要-1个硬币
         *     - 当i>0时，需要dp[i]个的硬币
         *
         */
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j]<=i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[]conis = {2,1,5};
        int amount=27;
        System.out.println(coinChange(conis,amount));
    }
}
