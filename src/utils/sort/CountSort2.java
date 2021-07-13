package utils.sort;

import utils.MyPrintFunction;


public class CountSort2 {
    public void sort(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        int [] carry = new int[max - min + 1];
        for (int i = 0; i < n; i ++) {
            carry[nums[i] - min] ++;
        }
        int index = 0;
        for (int i = 0; i < max - min + 1; i ++) {
            for (int j = 0; j < carry[i]; j++) {
                nums[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {92,98,99,97,94,91,90,93};
        new CountSort2().sort(nums);
        MyPrintFunction.print(nums);
    }
}
