package middle;

public class SearchMid {
    public static int search2(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid])//target在前半部分
            {
                if (nums[0] <= target && target < nums[mid]) {//target在前半部分
                    r = mid - 1;
                } else {//target在后半部分
                    l = mid + 1;
                }
            } else {
                if (nums[nums.length - 1] >= target && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        if (nums.length == 2) {
            return nums[0] == target ? 0 : nums[1] == target ? 1 : -1;
        }
        int l1 = 0, r1 = 0, l2, r2 = nums.length - 1;
        for (int i = 0; i < r2 - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                r1 = i;
                break;
            }
            if (i == r2 - 1)
                r1 = r2;
        }
        l2 = r1 + 1;

        if (target > nums[r1] || target < nums[l2])
            return -1;

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid])//target在前半部分
            {
                if (nums[0] <= target && target < nums[mid]) {//target在前半部分
                    r = mid - 1;
                } else {      //target在后半部分
                    l = mid + 1;
                }
            } else {
                if (nums[nums.length - 1] >= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }


        //对前半部分进行二分查找
//        if (target < nums[l1]) {
//            while (l2 <= r2) {
//                int mid2 = (l2 + (r2 - l2) / 2);
//                if (nums[mid2] == target)
//                    return mid2;
//                else if (nums[mid2] > target) {
//                    r2 = mid2 - 1;
//                } else {
//                    l2 = mid2 + 1;
//                }
//            }
//        } else if (target > nums[r2])
//            while (l1 <= r1) {
//                int mid1 = l1 + (r1 - l1) / 2;
//                if (nums[mid1] == target)
//                    return mid1;
//                else if (nums[mid1] > target) {
//                    r1 = mid1 - 1;
//
//                } else {
//                    l1 = mid1 + 1;
//                }
//            }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        int target = 3;
        System.out.println(search2(nums, target));
    }
}
