package middle;

import org.junit.Test;

import java.util.Arrays;

public class NextPermutation {
    public static void solution(int[] nums) {
        if (nums.length <= 1)
            return;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            }
            if (i == nums.length - 1) {
                int t = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = t;
                return;
            }
            //此时i是边界的下标
            int min = i;
            for (int j = nums.length-1; j >=i ; j--) {
                if (nums[j]>nums[i-1] && nums[j] <nums[min])
                    min=j;
            }
            int t = nums[i - 1];
            nums[i - 1] = nums[min];
            nums[min] = t;
            int s = i;
            for (int j = s; j < nums.length - 1; j++) {
                for (int k = s; k < nums.length-1; k++) {
                    if (nums[k] > nums[k + 1]) {
                        t = nums[k];
                        nums[k] = nums[k + 1];
                        nums[k + 1] = t;
                    }
                }
            }
            return;
        }
        int k = 0, j = nums.length - 1;
        while (k < j) {
            int t = nums[k];
            nums[k++] = nums[j];
            nums[j--] = t;
        }
    }

    public static void main(String[] args) {
//        int[] n = {5,1,1};//15234
        int []n={1,4,5,3,2};
//        int []n={1,3,2};
        System.out.println(Arrays.toString(n));
        solution(n);
        System.out.println(Arrays.toString(n));
    }
}
