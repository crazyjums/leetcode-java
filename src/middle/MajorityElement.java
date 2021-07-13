package middle;

import utils.MyPrintFunction;

import java.util.*;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int k = n / 2;
        int l = 0, r = n - 1;
        int mid = partition(nums, l, r);
        while (mid != k) {
            if (mid > k - 1) {
                r = mid - 1;
            } else
                l = mid + 1;
            mid = partition(nums, l, r);
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pv = nums[left], l = left, r = right;
        while (l != r) {
            while (l < r && nums[r] >= pv) r--;
            while (l < r && nums[l] <= pv) l++;
            if (l < r) {
                nums[l] = nums[l] ^ nums[r];
                nums[r] = nums[l] ^ nums[r];
                nums[l] = nums[l] ^ nums[r];
            }
        }
        nums[left] = nums[l];
        nums[l] = pv;
        return l;
    }

    public static int[][] test() {
        List<int[]> r = new ArrayList<>();
        int[] t= new int[2];
        t[0] = 1;
        t[1] = 2;
        r.add(t);
        return r.toArray(new int[r.size()][]);
    }

    public static void main(String[] args) {
//        int [] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
//        System.out.println(new MajorityElement().majorityElement(a));
//        MyPrintFunction.print2DArray(test());


        /**
         * 题目：给定两个数组：求只有a中函数有的元素而b中没有的元素
         *      只有b中含有的元素而a中没有的元素
         *
         * */

        int[] a = {3,4,1,2,4,4,4,5};
        int[] b = {5,6,3,4,5,5,5};
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        int l1 = 0;
        int l2 = 0;
        int pre1 = -1;
        int pre2 = -1;
        List<Integer> same = new ArrayList<>();
        while (l1 < a.length && l2 < b.length) {
            if (a[l1] == b[l2]) {
                same.add(a[l1]);
                l1 ++;
                l2 ++;
            } else {
                if (a[l1] < b[l2]) {
                    if (res1.size() == 0 || !same.contains(a[l1])) {
                        res1.add(a[l1]);
                    }
                    l1 ++;
                } else {
                    if (res2.size() == 0 || !same.contains(b[l2])) {
                        res2.add(b[l2]);
                    }
                    l2 ++;
                }
            }
        }

        while (l1 < a.length) {
            if (!same.contains(a[l1]))
                res1.add(a[l1++]);
            else
                l1 ++;
        }
        while (l2 < b.length) {
            if (!same.contains(b[l2]))
                res2.add(b[l2++]);
            else
                l2 ++;
        }

        MyPrintFunction.print(res1);
        MyPrintFunction.print(res2);
    }
}
