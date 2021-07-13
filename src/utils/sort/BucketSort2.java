package utils.sort;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort2 {
    public void sort(double[] nums) {
        int n = nums.length;
        double min = nums[0];
        double max = nums[0];//计算最大值和最小值
        for (int i = 1; i < n; i++) {
            if (nums[i] > max)
                max = nums[i];
            if (nums[i] < min)
                min = nums[i];
        }
        //创建桶
        int bucketNum = (int)((max - min) / (n - 1));
        List<List<Double>> bucket = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int bucIndex = (int)((nums[i] - min) / n);
            bucket.get(bucIndex).add(nums[i]);
        }
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucket.get(i));
        }
        int index = 0;
        for (int i = 0; i < bucketNum; i ++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                nums[index ++] = bucket.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        double[]a = {12,0.052,4.52,2.01,9.36,1.63};
        new BucketSort2().sort(a);
        MyPrintFunction.print(a);
        List<Integer> list = new ArrayList<>();

    }
}
