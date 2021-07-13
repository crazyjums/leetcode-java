package secondTime;

import utils.MyPrintFunction;

public class MySort {

    public int[] sort(int[]nums){
        sort(nums,0,nums.length-1);
        return nums;
    }

    private void sort(int[]nums,int start,int end){
        if (start>=end)
            return;
        int pIndex = partition(nums,start,end);
        sort(nums,start,pIndex-1);
        sort(nums,pIndex+1,end);
    }

    private int partition(int[] nums, int start, int end) {
        int pValue = nums[start];
        int mark = start;
        for (int i = start; i <= end; i++) {
            if (nums[i]<pValue){
                mark++;
                int t = nums[i];
                nums[i] = nums[mark];
                nums[mark]=t;
            }
        }
        nums[start] = nums[mark];
        nums[mark] = pValue;
        return mark;
    }

    public static void main(String[] args) {
        int[]nums={5,1,6,2,5};
        MySort mySort = new MySort();
        MyPrintFunction.print(nums);
        MyPrintFunction.print(mySort.sort(nums));
    }
}
