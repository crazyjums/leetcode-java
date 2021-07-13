package simple;

import java.util.Arrays;

/***
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int [] res={0,0};
//        for (int i = 0;i<length;i++){
//            for (int j=1;j<length;j++){
//                if ((nums[i]+nums[j])==target && i!=j){
//                    res[0]=i;
//                    res[1]=j;
//                    break;
//                }
//            }
//        }

        int l = 0, r = length - 1;
        while (l<r){
            if (nums[l] + nums[r] == target){
                res[0] = nums[l];
                res[1] = nums[r];
                return res;
            }
            if (nums[l] + nums[r] > target)
                r--;
            if (nums[l] + nums[r] < target)
                l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,4,5};
        int target = 9;
        int []res = twoSum(nums,target);
        System.out.println(Arrays.toString(res));
    }
}
