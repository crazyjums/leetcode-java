package middle;

import utils.MyPrintFunction;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length<=1)return nums.length;
        int n=nums.length;
        int []dp=new int[n];//表示以nums[i]结尾的数组的最长上升子序列的长度
        int[]count = new int[n];//表示以nums[i]结尾的数组的最长上升子序列的个数
        int max = 1;//记录最长递增子序列的长度
        for (int i = 0; i < n; i++) {
            dp[i]=1;//初始值为1，如果数组只有一个元素，必然存在一个数是上升序列，
            count[i]=1;//初始值为1，如果数组只有一个元素，必然存在一个上升序列
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    if (dp[j]>=dp[i]){//表示第一次遇到以nums[i]结尾的LIS
                        dp[i] = Math.max(dp[i],dp[j]+1);
                        count[i] = count[j];
                    }else if (dp[j]+1==dp[i]){//表示以nums[i]的结尾的LIS已经找到过一次了
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max,dp[i]);
        }
        MyPrintFunction.print(count);
        MyPrintFunction.print(dp);
        int res=0;
        for (int i = 0; i < n; i++) {
            if (dp[i]==max)//当以nums[i]结尾的数组的最长递增子序列的长度等于最大的值时，记录共有多少条
                res+=count[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={1,3,5,4,7};
        System.out.println(new FindNumberOfLIS().findNumberOfLIS(nums));
    }
}
