package hard;

import utils.MyPrintFunction;

public class CountRangeSum {
    int res = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        /**
         * 思路： 使用前缀和数组+归并排序
         *  假如有两个有序的数组，n1和n2，如果在这两个数组查找区间和的个数，则当n2[l] - n1[0] >= lower时， l++。l和r都指向n2数组的开头
         *
         * */
        long[] presum = new long[nums.length];
        long s = 0;
        for (int i = 0; i < nums.length; i ++) {
            s += (long)nums[i];
            presum[i] = s;
        }
        long[] temp = new long[nums.length];
        mergeSort(temp, lower, upper, 0, nums.length - 1, presum);
        return res;
    }

    private void mergeSort(long[] temp, int lower, int upper, int left, int right, long[] presum) {
        if (left == right) {
            if (presum[left] >= lower && presum[left] <= upper)
                res ++;
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(temp, lower, upper, left, mid, presum);
        mergeSort(temp, lower, upper, mid + 1, right, presum);

        //在合并数组之前，先统计和数量
        int i = left;
        int jl = mid + 1;
        int jr = mid + 1;
        while (i <= mid) {
            while (jl <= right && presum[jl] - presum[i] < lower)
                jl ++;
            jr = jl;
            while (jr <= right && presum[jr] - presum[i] <= upper) {
                jr++;
                res ++; //表示有一个符合要求的索引对
            }
            i++;
        }

        //归并排序的合并数组
        int p1 = left, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= right) {
            if (presum[p1] <= presum[p2]) {
                temp[p++] = presum[p1++];
            } else
                temp[p++] = presum[p2++];
        }

        while (p1 <= mid)
            temp[p++] = presum[p1++];
        while (p2 <= right)
            temp[p++] = presum[p2++];
        p = 0;
        while (left <= right)
            presum[left++] = temp[p++];
    }

    public static void main(String[] args) {
        int[] nums = {2147483647,-2147483648,-1,0};
        int res = new CountRangeSum().countRangeSum(nums,-1,0);
        System.out.println(res);
    }
}
