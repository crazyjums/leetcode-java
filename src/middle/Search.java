package middle;

public class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1) return target == nums[0] ? 0 : -1; //只有一个元素
        int l = 0;
        int r = nums.length - 1;
        /*
            可以认为这个数组是由两个升序数组组成，前面部分的最小值大于后边部分的最大值
        */
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= nums[0]) { //说明当前查询的是前半部分的数组
                if (target >= nums[0] && nums[mid] > target)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else { //(nums[mid] <= nums[n - 1]) {
                if (target <= nums[n - 1] && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (nums[mid]==target)return mid;
            if (nums[0] <= nums[mid])//target在前半部分
            {
                if (nums[0]<=target && target<nums[mid]){//target在前半部分
                    r=mid-1;
                }else{//target在后半部分
                    l=mid+1;
                }
            }else{
                if (nums[nums.length-1]>=target && target > nums[mid]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5,1,3};
        int res = new Search().search(a, 5);
        System.out.println(res);
    }
}
