package middle;

import utils.MyPrintFunction;

public class MaxProfit {
    /**
     * 使用动态规划的思路解题：
     * 1. 确定动态规划数组的含义： dp[i]表示从第1天到第i天所能获得的股票的最大利润
     * 2. 确定初始状态：第一天的股票利润是0
     * 3. 确定状态转移方程：
     *    - 第i天的股票最大利润是第i天的股票最大利润和第i-1天的股票最大利润的最大值
     *    - 第i天的股票最大利润如何求：第i天的股票价格-历史股票的最低价格：即prices[i]-minPrice
     *    则状态转移方程：dp[i] = max(dp[i-1], prices[i]-minPrice )
     *
     * @param prices 股票价格
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length==0)
            return 0;
        //dp[i]数组表示从第1天到第i天的股票最大利润
        int[]dp=new int[prices.length];
        dp[0]=0;//确定初始装填
        int minPrice = prices[0];//用来记录从第1天到第i天以来的最低股票价格
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<minPrice)
                minPrice = prices[i];
            dp[i] = Math.max(dp[i-1],prices[i]-minPrice);
        }

        MyPrintFunction.print(dp);
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        int []a={7,1,5,3,6,4};
        MaxProfit maxProfit= new MaxProfit();
        System.out.println(maxProfit.maxProfit(a));
    }
}
