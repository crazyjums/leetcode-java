package simple;

public class SearchNumbers {
    public int search(int[] nums, int target) {
        /**
         * 以[1,2,3,4,4,4,5,6]为例，
         * leftBound等于3的索引，rightBound等于5的索引，所以重复数字的长度应该rightBound-leftBound-1，
         * 两边都是开区间
         * 思路：
         *    1 使用二分查找算法查找重复数字的左右边界，这样能够将时间复杂度降到O(logn)，
         *    如果使用二分查找，找到一个数之后，在向两边扩散，时间复杂度最坏是O(n)
         *    2 寻找右边界：
         *      - 当nums[mid]与target相等时，则说明右边界在mid的右边，此时到数组的右边继续查找，l=mid-1
         *      - 当target>nums[mid]时，说明target在数组右边，到数组右边查找，l=mid-1
         *      - 当target<nums[mid]时，说明target在数组左边，到数组左边查找，r=mid-1
         *      rightBound等于左指针的索引，因为，当nums[mid]==target时，则nums[l]（l=mid+1）一定不等于target
         *    3 寻找左边界
         *      - 当nums[mid]==target时，说明左边界在数组左边，r=mid-1
         *      - 当nums[mid]>target时，说明target在数组左边，r=mid-1
         *      - 当nums[mid]<target时，说明target在数组右边，l=mid-1
         *      leftBound等于右指针的索引，因为，当nums[mid]==target时，则nums[r]（r=mid-1）一定不等于target
         *
         *    4 在寻找到右边界时，应该判断一下target是否在数组中，如果不在，则返回0
         *    此时的nums[r]便是target的值，如果存在的话
         */
        if (nums.length == 0)
            return 0;
        if (target > nums[nums.length - 1] || target < nums[0])
            return 0;

        int leftBound = 0, rightBound = 0;//重复数字的左右边界
        int l = 0, r = nums.length - 1;
        //1.先查找右边界 leftBound
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid]==target){//当mid索引值等于target时，说明右边界在右边
                l = mid+1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else
                r = mid-1;
        }
        rightBound = l;
        //如果数组没有target，则返回0
        if (r>=0&&nums[r]!=target)
            return 0;

        //2.查找左边界
        l=0;
        r=rightBound;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid]==target){
                r = mid-1;
            }else if (nums[mid] > target){
                r = mid-1;
            }else
                l=mid+1;
        }

        leftBound = r;
        return rightBound - leftBound - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 4,4,4,4, 5, 8};
        SearchNumbers searchNumbers = new SearchNumbers();
        int res = searchNumbers.search(nums, 4);
        System.out.println(res);
    }
}
