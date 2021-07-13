package middle;

import java.util.Arrays;

public class FindNextestNumber {
    public int[] findNestestNumber(int[] nums) {
        if (nums.length < 2)
            return nums;
        for (int i = nums.length-1;i >0 ; i--) {
            /**
             * 分两种情况，第一种情况，
             * 比如：12345，最后一位的数刚好大于第（n-2）位数，则只需要交换第（n-1）和（n-2）位置上的数即可
             *
             * 第二种情况：
             * 比如：12543， 大于前面一面的数不在最后而在中间，所以需要知道其边界，并交换
             */
            int t=0;
            // 如果小于则继续
            if (nums[i] <= nums[i-1])
                continue;
            //极端情况1：最后两位刚好是顺序排列的
            if (i==nums.length-1){
                t = nums[i];
                nums[i] = nums[i-1];
                nums[i-1]=t;
                break;
            }
//            //极端情况2 刚好是倒序排列的
//            if (i==0)
//                break;

            i--;//此时得到的是边界处的索引，所以i需要-1
            for (int j = nums.length-1; j >i ; j--) {
                if(nums[j] > nums[i]){
                    t = nums[i];
                    nums[i]=nums[j];
                    nums[j]=t;
                    break;
                }
            }
            int start = i+1;
            for (int j = start; j < nums.length-1; j++) {
                for (int k = start; k < nums.length-1; k++) {
                    if (nums[k] > nums[k+1]){
                        t = nums[k];
                        nums[k]=nums[k+1];
                        nums[k+1]= t;
                    }
                }
            }
            return nums;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(Arrays.toString(nums));
        FindNextestNumber findNextestNumber = new FindNextestNumber();
        int[] res = findNextestNumber.findNestestNumber(nums);
        System.out.println(Arrays.toString(res));
    }
}
