package simple;

public class MaxProfit {
    // 暴力求解
    public int maxProfit(int[] prices) {
        int res = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (prices[j] - prices[i] > res && j > i) {
                    res = prices[j] - prices[i];
                }
            }
        }
        return res;
    }
    // 简化版
    public int maxProfit2(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minprice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            if (prices[i] - minprice > maxProfit)
                maxProfit = prices[i] - minprice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 4, 3, 1};
        int[] nums2 = {7,1,5,3,6,4};

        MaxProfit maxProfit = new MaxProfit();

        System.out.println(maxProfit.maxProfit2(nums));
        System.out.println(maxProfit.maxProfit2(nums2));
    }
}
