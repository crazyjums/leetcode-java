package middle;

import java.util.Arrays;

public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * 思路：先对数组进行升序排序，然后使用双指针进行查找
         */
        Arrays.sort(nums);
        int n = nums.length;
//        int min = 10000000;
        int min = Integer.MAX_VALUE;//int类型越界
        for (int i = 0; i < n; ++i) {
            //防止重复计算
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == target)//如果等于target 直接返回即可
                    return target;
                //如果当前的和最靠近target 那么替换之前的和
                if (Math.abs(sum - target) < Math.abs(min - target))
                    min = sum;
                if (sum > target) {//和太大，应该将右指针左移动
                    --r;
//                    int r0 = r - 1;
//                    while (l < r0 && nums[r0] == nums[r])
//                        --r0;
//                    r = r0;
                } else //和偏小，应该左指针  向右移动
                {
                    ++l;
//                    int l0 = l + 1;
//                    while (l0 < r && nums[l0] == nums[l])
//                        ++l0;
//                    l = l0;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        System.out.println(new threeSumClosest().threeSumClosest(nums, -1));
    }
}
