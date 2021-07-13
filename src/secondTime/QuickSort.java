package secondTime;

import utils.MyPrintFunction;

public class QuickSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int pIndex = partition(nums, start, end);
        sort(nums, start, pIndex - 1);
        sort(nums, pIndex + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int p = nums[start];
        int l = start, r = end;
        while (l < r) {
            while (l < r && nums[r] < p)
                r--;
            while (l < r && nums[l] >= p)
                l++;


            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        nums[start] = nums[l];
        nums[l] = p;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 4, 1, 9, 3, 2};
        MyPrintFunction.print(nums);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        MyPrintFunction.print(nums);
    }
}
