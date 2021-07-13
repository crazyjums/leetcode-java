package middle;

import utils.sort.QuickSort;

import java.util.*;

/**
 * 找出无序数组中，有序后的最大相邻差
 */
public class GreatestGapSort {

    public int bruteForce(int []nums){
        int distance = 0;
        QuickSort quickSort = new QuickSort(nums);
        quickSort.increaseSortBySingle();

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] - nums[i] > distance)
                distance = nums[i+1] - nums[i];
        }
        return distance;
    }


    public int greatestGapSort(int[] nums) {
        //(1) 确定数组中的最大值和最小值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //（2）确定桶的长度，并创建空桶
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }
        //(3) 计算每个桶的最大值和最小值，最小值放在0的位置，最大值放在1的位置
        for (int i = 0; i < nums.length; i++) {
            int numIndex = (nums[i] - min) / nums.length;
            //确定桶中的最小值
            if (bucket.get(numIndex).size() != 0) {
                if (nums[i] < bucket.get(numIndex).get(0))
                    bucket.get(numIndex).add(0, nums[i]);
            } else
                bucket.get(numIndex).add(0, nums[i]);

            //确定桶中的最大值
            if (bucket.get(numIndex).size() >= 2) {
                if (nums[i] > bucket.get(numIndex).get(1))
                    bucket.get(numIndex).add(1, nums[i]);
            } else
                bucket.get(numIndex).add(1, nums[i]);
        }
        //(4) 计算有序之后的最大相邻差，
        int leftMax = 0;//用来保存前一个桶中的最大值
        int distance = Integer.MIN_VALUE;//最大相邻差

        for (int i = 0; i < bucketNum; i++) {
            if (bucket.get(i).size() != 0) {
                if (bucket.get(i).get(0) - leftMax > distance) //如果当前相邻值的差，大于之前的距离则覆盖之前的
                    distance = bucket.get(i).get(0) - leftMax;
                leftMax = bucket.get(i).get(1);//前一个桶的最大值移动
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 2, 9, 10, 20, 44, 39};
        GreatestGapSort greatestGapSort = new GreatestGapSort();
        System.out.println(greatestGapSort.greatestGapSort(nums));
    }
}
