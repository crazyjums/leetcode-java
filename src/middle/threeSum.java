package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i>0&&nums[i]==nums[i-1])
                continue;

            int target = -nums[i];//将三数之和 转成两数之和
            int l = 0,k=n-1;
            for (int j = i+1; j < n; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){//重复元素 向后移动
                    continue;
                }
                while (j<k && nums[j] + nums[k] > target) //如果两个数的和大于了目标值，说明结果偏大，应该让右指针左移
                    k--;
                if (k==j)//指针重合 退出 因为有重复
                    break;

                if (nums[j]+nums[k]==target){//如果相等  则添加到结果集中
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[k]);
                    res.add(path);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        /**
         * 思路：
         * 将数组拍好序，时间复杂度为O(logn)
         * 然后从第一个元素开始，将三数之和变成两数之和，将问题简单化
         * 因为和为一个固定值0，所以两数之和的值为第i个元素的负数，
         * 然后使用双指针方法选择，当两数之和大于第i个元素的负数时，表示当前和
         * 偏大，右指针应该左移，因为数组是从小到大排序的，如果小于则左指针右移动
         * 如果相等则添加到结果集
         */
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i>0 && nums[i]==nums[i-1])
                continue;

            int target = -nums[i];
            int l=i+1,r=n-1;
            while (l<r){
                int sum = nums[l]+nums[r];
                if (sum==target){
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[l]);
                    path.add(nums[r]);
                    res.add(path);
                    //跳过重复的值
                    while (l<r && nums[l]==nums[l+1])
                        l++;
                    //跳过重复的值
                    while (l<r&&nums[r]==nums[r-1])
                        r--;
                    //左右指针应该都移动 题目说不能重复
                    l++;//左指针应该向右移动
                    r--;//右指针应该向左移动
                }else if (sum>target)
                    r--;
                else
                    l++;
            }

        }
        return res;
    }

    private int getSum(int[]nums,int i,int j,int k){
        return nums[i]+nums[j]+nums[k];
    }

    public static void main(String[] args) {
        int[]nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = new threeSum().threeSum2(nums);
        MyPrintFunction.print(res);
    }
}
