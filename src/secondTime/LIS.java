package secondTime;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.Comparator;

public class LIS {
    public int lis(int[] nums) {
        /**
         * 思路：
         *      动态规划，时间复杂度是O(N*N)
         */
        if (nums.length <= 1)
            return nums.length;
        int[] dp = new int[nums.length+1];
        dp[0]=1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if (nums[i]>nums[j])
                    dp[i]=Math.max(dp[i],dp[j]+1);
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public int lis2(int[]nums){
        /**
         * 贪心算法+二分查找：
         *      时间复杂度是O(N*logN)
         */
        if (nums.length<=1)return nums.length;
        int n=nums.length;
        int maxlen = 1;
        int[]dp=new int[n+1];//dp[i]表示长度为i的最长上升子序列末尾的最小值，即数组dp是递增的
        dp[maxlen]=nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i]>dp[maxlen]){//如果当前值大于dp数组的最大值，则直接添加dp数组末尾
                dp[++maxlen]=nums[i];
            }else{//如果当前值小于dp数组的最大值，则再dp数组中找到一个仅仅大于当前值的数，并用当前值替换掉dp数组中的数，
                //如果没有这个数，则替换第0个位置的数
                int l=1,r=maxlen;
                while (l<=r){
                    int mid = l+(r-l)/2;
                    if (dp[mid]>nums[i]){
                        r=mid-1;
                    }else{
                        l=mid+1;
                    }
                }
                dp[l]=nums[i];
            }
        }
        MyPrintFunction.print(dp);
        return maxlen;
    }


    public static void main(String[] args) {
        Integer[] nums = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(nums));
//        LIS lis = new LIS();
//        int res = lis.lis2(nums);
//        System.out.println(res);
    }
}

