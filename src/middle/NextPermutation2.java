package middle;

import utils.MyPrintFunction;

public class NextPermutation2 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) continue;
            //12345 -> 12354 如果是升序的数组，则只需要调换最后两个数组的位置即可
            if (i == nums.length - 1) {
                nums[i] = nums[i - 1] ^ nums[i];
                nums[i - 1] = nums[i - 1] ^ nums[i];
                nums[i] = nums[i - 1] ^ nums[i];
                return;
            }
            //如果不是严格升序的，则需要找到nums[i]>nums[i-1]的边界，从第i到第nums.length-1的闭区间中找到一个大于nums[i-1]的最小值
            int min = i;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1] && nums[j] < nums[min]) {
                    min = j;
                }
            }
            //替换数字
            nums[i] = nums[min] ^ nums[i];
            nums[min] = nums[min] ^ nums[i];
            nums[i] = nums[min] ^ nums[i];

            for (int j = i; j < nums.length - 1; j++) {
                for (int k = i; k < nums.length - 1; k++) {
                    if (nums[k] > nums[k +1]) {
                        nums[k] = nums[k] ^ nums[k + 1];
                        nums[k + 1] = nums[k] ^ nums[k + 1];
                        nums[k] = nums[k] ^ nums[k + 1];
                    }
                }
            }
            return;
        }
        //倒序数组
        int l = 0, r = nums.length - 1;
        while (l < r) {
            nums[l] = nums[l] ^ nums[r];
            nums[r] = nums[l] ^ nums[r];
            nums[l] = nums[l] ^ nums[r];
            l ++;
            r --;
        }
    }

    public static void main(String[] args) {
        int [] nums = {5,1,1};
        MyPrintFunction.print(nums);
        new NextPermutation2().nextPermutation(nums);
        MyPrintFunction.print(nums);
    }
}
