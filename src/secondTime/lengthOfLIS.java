package secondTime;

import utils.MyPrintFunction;

import java.util.Arrays;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1)return nums.length;
        int n = nums.length;
        int max = 1;
        /**
         * dp[i]表示以第i个数为结尾的数组的最长上升子序列的长度（包括nums[i]），如果需要计算
         * 以第i+1个数结尾的数组的LIS，则只需要判断是否nums[i+1]>nums[i]?，如果大于，在
         * 之前的基础上+1，否则不变
         */
        int[]dp=new int[nums.length];
        for (int i = 0; i < n; i++) {
            dp[i]=1;//默认值都设为1
            for (int j = 0; j <= i; j++) {
                if (nums[i]>nums[j])
                /**
                 * 如果nums[i]>nums[j]的话：
                 *      防止重复计数，取以nums[i]结尾的数组和以nums[j]结尾的数组的最长上升子序列的最大值，
                 *      即dp[i]和dp[j]+1，因为nums[i]>nums[j],所以需要在dp[j]的基础上加1
                 */
                    dp[i]=Math.max(dp[i],dp[j]+1);
                max = Math.max(dp[i],max);
            }

        }
        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length<=1)return nums.length;
        int n = nums.length;
        int d[]=new int[n+1];//表示长度为i的最长递增子序列的末尾的最小值
        int len = 1;//表示最长子序列的长度，初始值为1
        d[len]=nums[0];//初始状态下，长度为1的最长递增子序列的末尾最小值是数组的第0个元素
        for (int i = 1; i < n; i++) {
            if (nums[i]>d[len]){//如果第i个元素的值大于长度为len的最长递增子序列的末尾元素的最小值，则LIS长度加1
                d[++len]=nums[i];
            }else{//如果不大于，则在数组d中查找一个比值，使其满足d[i-1]<nums[j]<d[i]
                //如果找不到比nums[i]更小的数，此时将nums[i]更新到d[1]即可，即第一个位置的数
                int l = 1,r=len,pos=0;
                while (l<=r){
                    /**
                     * int mid = l + (r-l)/2;应该这样写：mid=(l+((r-l)>>1))
                     */
                    int mid = (l + ((r-l)>>1));
                    /**
                     * //因为需要在数组d中找到一个介于d[mid-1]和d[mid]之间的数，
                     * 所以当nums[i]在数组右边时，应该往右边找，在左边时，应该往左边找
                     */
                    if (d[mid]<nums[i]){
                        pos = mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                d[pos+1]=nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[]nums = {3,5,6,2,5,4,19,5,6,7,12};
        int res = new lengthOfLIS().lengthOfLIS2(nums);
        System.out.println(res);
    }
}
