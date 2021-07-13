package hard;

import utils.MyPrintFunction;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int n = nums.length;
        if (n <= 0) return n + 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int t = Math.abs(nums[i]);
            if (t <= n) {
                nums[t-1]=-Math.abs(nums[t-1]);
            }
        }
        MyPrintFunction.print(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums.length == 0) return 1;
        int n = nums.length;
        if (n <= 0) return n + 1;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int j = nums[i] - 1; //将1...N的数放到数组中，下标从0开始，所以先减1
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                return i;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int res = firstMissingPositive.firstMissingPositive(nums);
        System.out.println(res);
    }
}
