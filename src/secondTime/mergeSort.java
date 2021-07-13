package secondTime;

import utils.MyPrintFunction;

/**
 * 归并排序
 */
public class mergeSort {

    public void sort(int[]nums){
        if (nums==null||nums.length<=0)return;
        int[]temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
    }

    private void sort(int []nums,int left,int right,int []temp){
        if (left>=right)
            return;
        int mid = left + (right - left)/2;
        sort(nums,left,mid,temp);
        sort(nums,mid+1,right,temp);

        merge(nums,left,mid,right,temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int p1 = left, p2 = mid+1, p = 0;
        while (p1 <= mid && p2 <= right){
            if (nums[p1]<=nums[p2]){
                temp[p++] = nums[p1++];
            }else
                temp[p++] = nums[p2++];
        }

        while (p1<=mid){
            temp[p++] = nums[p1++];
        }

        while (p2<=right)
            temp[p++] = nums[p2++];

        p = 0;
        while (left<=right)
            nums[left++] = temp[p++];
    }

    public static void main(String[] args) {
        int []nums={5,6,3,1,9,8,10,0,4};
        mergeSort m = new mergeSort();
        m.sort(nums);
        MyPrintFunction.print(nums);
    }
}
