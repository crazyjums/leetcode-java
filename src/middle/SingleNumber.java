package middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums={0,0,1,1,0,1,99};
        System.out.println(singleNumber.solution(nums));
        System.out.println(~100);
    }

    public int solution(int[] nums) {
        int res = 0;
        int n = nums.length;
        int bits []=  new int[32];
        for(int num:nums){
            int bitMask = 1;
            for (int i = 31; i >=0; i--) { // 从高位向低位计算
                if ((num & bitMask) != 0) //说明当前位是1
                    bits[i] += 1;
                bitMask <<= 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += bits[i] % 3;
        }
        return res;
    }

    public int solution2(int []nums){
        int n = nums.length;
        if(n==1)return nums[0];
        int ones =0 ,twos=0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
