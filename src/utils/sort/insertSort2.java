package utils.sort;

import utils.MyPrintFunction;

public class insertSort2 {
    public static void main(String[] args) {





    }

    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n ; i++) {
            int preIndex = i - 1;
            int curData = nums[i];
            while (preIndex >= 0 && nums[preIndex] < curData) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex --;
            }
            if (preIndex + 1 != i) {
                nums[preIndex + 1] = curData;
            }
            System.out.print("i = " + i + "  ");
            MyPrintFunction.print(nums);
        }
    }
}
