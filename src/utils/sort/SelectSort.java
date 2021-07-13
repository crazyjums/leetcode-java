package utils.sort;

import java.util.Arrays;

public class SelectSort {
    public void sort(int[]nums){
        int n=nums.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                minIndex = nums[minIndex] > nums[j] ? j:minIndex;
            }
            int t = nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=t;
        }
    }

    public static void main(String[] args) {
        int[]nums={4,6,1,23,10,8,9};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
