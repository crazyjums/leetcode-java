package simple;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] res = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

        int[] res3 = maxSlidingWindow.maxSlidingWindow3(nums, k);
        System.out.println(Arrays.toString(res3));
    }

    //暴力破解
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = {};
        if (n == 0)
            return res;
        if (k > n)
            return res;
        if (k == 1)
            return nums;
        res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            res[i] = nums[i];
            for (int j = 1; j < k; j++) {
                if (res[i] < nums[i + j]) {
                    res[i] = nums[i + j];
                }
            }
        }
        return res;
    }

    //双端队列实现
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] res = {};
        if (n == 0 || k==0 || k>n)
            return res;
        if (k == 1)
            return nums;
        res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) { //形成窗口前
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst(); //将当前队列中的最大元素添加到结果数组中
        for (int i = k; i < n; i++) { //对之后的数据再次循环
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && nums[i] > deque.peekLast())
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

}
