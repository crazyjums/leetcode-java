package simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target < nums[0])
            return 0;
        else if (target > nums[n - 1])
            return n;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
                if(nums[left]>target){
                    return left;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
                if (nums[right]<target){
                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int[] nums = {1, 3, 5, 6, 9, 13, 17, 20, 22};
        int[] target = {1,0,4,7,10,23};
        for (int i = 0; i <target.length ; i++) {
            System.out.println(searchInsert.searchInsert(nums, target[i]));
        }

    }
}
