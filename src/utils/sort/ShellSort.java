package utils.sort;

import utils.MyPrintFunction;

public class ShellSort {
    public void sort(int[] nums) {
        for (int gap = nums.length/2; gap > 0; gap = gap/2) {
            for (int i = 1; i < nums.length; i++) {
                int p = i - gap;
                int cur_data = nums[i];
                while (p >= 0 && nums[p] > cur_data) {
                    nums[p + gap] = nums[p];
                    p = p - gap;
                }
                if (p + gap != i)
                    nums[p + gap] = cur_data;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        new ShellSort().sort(nums);
        MyPrintFunction.print(nums);

        StringBuilder sb = new StringBuilder();

    }
}
