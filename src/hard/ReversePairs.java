package hard;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.Collections;

/**
 * 使用归并排序的思想解题
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        int[] tem = new int[n];
        int count = reversePairs(nums, 0, n - 1, tem);
        return count;
    }

    /**
     * 在区间[start....end]进行查找
     *
     * @param nums
     * @param start
     * @param end
     * @param tem
     * @return
     */
    private int reversePairs(int[] nums, int start, int end, int[] tem) {
        if (start == end) {//当[start....end]只剩下一个元素的时候，不存在逆序对
            return 0;
        }
        int mid = start + (end - start) / 2;//向下取整

        //对数组左边的元素中的逆序对个数进行计算
        int leftCount = reversePairs(nums, start, mid, tem);
        //对数组右边的元素中的逆序对的个数进行计算
        int rightCount = reversePairs(nums, mid + 1, end, tem);

        /**
         * 当左右两边的数组已经有序时，即nums[mid]<=nums[mid+1],就不需要在计算交叉区间的逆序对了
         */
        if (nums[mid]<=nums[mid+1])
            return leftCount+rightCount;


        //将跨越[start,mid]和[mid+1,end]两个区间的逆序对进行计算
        int crossCount = mergeAndCount(nums, start, mid, end, tem);
        return rightCount + leftCount + crossCount;
    }

    /**
     * 对跨越左右两个子数组的逆序对进行求和
     *
     * @param nums
     * @param start
     * @param mid
     * @param end
     * @param tem
     * @return
     */
    private int mergeAndCount(int[] nums, int start, int mid, int end, int[] tem) {
        int p1 = start, p2 = mid + 1;
        int count = 0;
        for (int p = start; p <= end; p++) {
            /**
             * p1的大小在[start,mid]的闭区间，如果p1的值不在该区间，则表明到了尾部
             * p2的大小在[mid+1,end]的闭区间，如果p2不在该区间，则表明到了尾部
             */
            if (p1 == mid + 1) {
                tem[p] = nums[p2++];
            } else if (p2 == end + 1) {
                tem[p] = nums[p1++];
            } else if (nums[p1] <= nums[p2]) {
                tem[p] = nums[p1++];
            } else {
                tem[p] = nums[p2++];
                count += (mid - p1 + 1);
            }
        }

        for (int i = start; i <=end ; i++) {
            nums[i]=tem[i];
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,3,4,2,5};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(nums));
    }
}
