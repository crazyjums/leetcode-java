package hard;

import utils.MyPrintFunction;

public class ReversePairs2 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return 0;
        int[] temp = new int[n];
        return reversePairs2(nums, 0, n - 1, temp);
    }

    private int reversePairs2(int[] nums, int left, int right, int[] temp) {
        if (left == right)//如果区间中只有一个元素，则没有逆序对
            return 0;

        int mid = left + (right - left) / 2;
        int leftCount = reversePairs2(nums, left, mid, temp);
        int rightCount = reversePairs2(nums, mid + 1, right, temp);

        //如果左边区间的元素都小于等于右边区间的元素，则不需要对交叉区间的的元素进行计算
        if (nums[mid] <= nums[mid + 1])
            return leftCount + rightCount;

        int crossCount = mergeCount(nums, left, mid, right, temp);
        return leftCount + rightCount + crossCount;
    }

    private int mergeCount(int[] nums, int left, int mid, int right, int[] temp) {
        int p1 = left, p2 = mid + 1, p = 0;
        int sum = 0;
        int count = 0;//用于统计逆序对的个数
        //由于是闭区间，所以两边都是等于号
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]){
                temp[p++] = nums[p1++];
            }
            else {

//                count += (mid - p1 + 1);
//                sum += (Math.abs(p1-p2));
                int t = p1;
                while (t<=mid)
                    sum += (nums[t++] - nums[p2]);
                temp[p++] = nums[p2++];
            }
        }

        while (p1 <= mid) {
            temp[p++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[p++] = nums[p2++];
        }
        p=0;
        while (left<=right)
            nums[left++]=temp[p++];

        return sum;
    }

    private static long getSum(int n){
        long res = 0;
        while(n!=0){
            res += (n%10);
            n /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,5};
        ReversePairs2 reversePairs2 = new ReversePairs2();

        System.out.println(reversePairs2.reversePairs(nums));
        MyPrintFunction.print(nums);

        System.out.println(getSum(5001));
        ;
    }

}
