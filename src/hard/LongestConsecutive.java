package hard;

import java.util.HashSet;

public class LongestConsecutive {
    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //利用集合去重
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;//记录最大的子序列，取所有count中的最大值
        int tem1 = 0;//向前查找
        int tem2 = 0;//向后查找
        int count = 0;//当前查找的最长序列
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) continue;//集合中没有该数，表示已经被记录过了
            /**
             * tem1表示nums[i]的值，向前查找。
             * tem2表示nums[i]+1，即tem1+1，向后查找，
             */
            tem1 = nums[i];
            tem2 = tem1+1;
            count = 0;
            //向前查找，即查找tem1-1,tem1-2,如tem1=10,则不断查找9,8,7...
            while (set.contains(tem1)) {
                count++;
                set.remove(tem1);
                tem1--;
            }
            //向后查找
            while (set.contains(tem2)) {
                count++;
                set.remove(tem2);
                tem2++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(solution(nums));
    }
}
