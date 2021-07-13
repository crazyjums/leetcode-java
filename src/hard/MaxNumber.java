package hard;

import utils.ListNode;
import utils.MyPrintFunction;

import java.util.*;

public class MaxNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        /*
        分别从nums1中取i个元素，从nums2中取k-i个元素，计算他们组合的最大值，
        比较这个k个数的大小，返回最大的那个即可
        **/
        int[] ans = new int[k];
        if (nums1.length + nums2.length == k) {
            ans = merge(nums1, nums2);
            return ans;
        }
        for (int i = Math.max(k - nums1.length, 0); i <= Math.min(nums2.length, k); i ++) {
            int[] tem = merge(selectNum(nums1, i), selectNum(nums2, k - i));
            // ans < tem -> ans = tem
            if (compare(tem, ans)) ans = tem;
        }
        return ans;
    }

    private int[] selectNum(int[] nums, int k) {
        int n = nums.length;
        if (n <= k) return nums;
        int drop = n - k; //表示需要丢弃的元素的个数
        int[] ans = new int[k];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peekLast() && drop > 0) {
                stack.pollLast();
                drop --;
            }
            stack.addLast(nums[i]);
        }
        while (stack.size() > k) stack.pollLast();
        int i = 0;
        for (Integer num : stack)
            ans[i ++] = num;
        return ans;
    }


    // //比较nums1和nums2的大小，nums1>nums2 -> true  else false
    private boolean compare(int[] nums1, int[] nums2) {
        for (int  i = 0; i < nums1.length && i < nums2.length; i++) {
            if (nums1[i] > nums2[i]) return true;
            else if (nums1[i] < nums2[i]) return false;
        }
        return nums1.length > nums2.length;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return nums1 == null ? nums2 : nums1;
        int[] res = new int[nums1.length + nums2.length];

        int l1 = 0;
        int l2 = 0;
        int l = 0;
        while (l < nums1.length + nums2.length) {
            if (compare(Arrays.copyOfRange(nums1, l1, nums1.length), Arrays.copyOfRange(nums2, l2, nums2.length))) {
                res[l ++] = nums1[l1 ++];
            } else
                res[l ++] = nums2[l2 ++];
        }
        while (l1 < nums1.length) res[l ++] = nums1[l1 ++];
        while (l2 < nums2.length) res[l ++] = nums2[l2 ++];

        return res;
    }

    public static void main(String[] args) {
        //[9,9,9,7,3,2,3,1,1]
//        int[] nums1 = {3,3,1,8,2,4,2,9,2,4,7,1,9,2,3,4,0,7,5,4};
//        int[] nums2 = {9,7,7,1,3,6,8,6,9,6,0,4,3,6,6,1,0,4,6,2,2,6,4,6,0,4,9,7,4,9,8,4,9,8,4,6,6,5,8,2,8,6,6,6,1,0,9,0,8,0,4,0,4,4,1,7,9,8,4,2,2,0,3,2,3,9,1,8,9,5,2,7,9,2,7,7,8,5,4,4,8,6,5,5,9,6,1,4,6,0,8,5,3,4,2,0,0,9,5,2};
        int[] nums1 = {8,9};
        int[] nums2 = {3,9};
        int k = 3;
        int[] res = new MaxNumber().maxNumber(nums1, nums2, k);
        MyPrintFunction.print(res);


        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,300);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        ListNode head = ListNode.getLink();
//        head.next = head.next.next;
        MyPrintFunction.print(head);
        ListNode mid = head;
        ListNode fa = head.next;
        while (fa != null && fa.next != null) {
            mid = mid.next;
            fa = fa.next.next;
        }
        System.out.println(mid.val);
    }
}
