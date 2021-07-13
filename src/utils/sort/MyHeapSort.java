package utils.sort;

import utils.MyPrintFunction;

public class MyHeapSort {
    public void sort(int[] nums) { //升序排序
        for (int i = nums.length / 2; i >= 0; i--) {
            downAdjust(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[0] ^ nums[i];
            nums[0] = nums[0] ^ nums[i];
            nums[i] = nums[0] ^ nums[i];
            downAdjust(nums, 0, i);
        }
    }

    private void downAdjust(int[] nums, int pIndex, int len) {
        int val = nums[pIndex];
        int cIndex = 2 * pIndex + 1;
        while (cIndex < len) {
            if (cIndex + 1 < len && nums[cIndex] < nums[cIndex + 1])
                cIndex++;
            if (val > nums[cIndex])
                break;
            nums[pIndex] = nums[cIndex];
            pIndex = cIndex;
            cIndex = 2 * pIndex + 1;
        }
        nums[pIndex] = val;
    }

    public static void main(String[] args) {
        int[] a = {4, 13, 8, 9, 10, 18, 16,78, 1,-9};
        MyPrintFunction.print(a);
        new MyHeapSort().sort(a);
        MyPrintFunction.print(a);
    }
}
