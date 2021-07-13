package utils.sort;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class InsertSort {
    public void sort(int[]nums){
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int preIndex = i - 1;
            int curData = nums[i];
            while (preIndex >= 0 && nums[preIndex] > curData) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            if(preIndex+1!=i)
                nums[preIndex+1] = curData;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[]nums={4,6,12,5,10,20,4,6};
        insertSort.sort(nums);
        MyPrintFunction.print(nums);
        List<Integer> a = new ArrayList<>();


    }
}
