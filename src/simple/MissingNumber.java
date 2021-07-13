package simple;

import utils.MyPrintFunction;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n<=0)return 0;
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            while (nums[i]<n&&nums[i]!=i){
                int j = nums[i];

                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i)return i;
        }
        return n;
    }

    public int missingNumber2(int[] nums) {
        if (nums.length<=0)return 0;
        int sum = (nums.length) * (nums.length + 1)/2;
        int _sum = 0;
        for (int i = 0; i < nums.length; i++) {
            _sum += nums[i];
        }
        int d = sum - _sum;
        return d;
    }

    public static void main(String[] args) {
        int[]nums={0,1,3};
        int res = new MissingNumber().missingNumber2(nums);
        System.out.println(res);
    }
}
