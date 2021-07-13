package hard;

import utils.MyPrintFunction;

import java.util.*;

public class MaxSildingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        思路：单调递减队列
        */

        Deque<Integer> queue = new ArrayDeque<>();

        int [] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (i < k) {
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                    queue.pollLast();
                queue.addLast(i);
            } else {
                if (!queue.isEmpty())
                    res[index ++] = nums[queue.peekFirst()];
                while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                    queue.pollLast();
                while (!queue.isEmpty() && i - queue.peekFirst() + 1 > k) queue.pollFirst();
                queue.addLast(i);
            }
        }
        res[index] = nums[queue.peekFirst()];
        return res;
    }

    public static void main(String[] args) {
//        int [] nums = {1,3,-1,-3,5,3,6,7};
        int [] nums = {5,6,7,8,9};
        int [] res = new MaxSildingWindow().maxSlidingWindow(nums,1);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        MyPrintFunction.print(a);
        queue.add(1);
        queue.add(-1);
        queue.add(3);
        System.out.println(queue.peek());
        MyPrintFunction.print(res);
    }
}
