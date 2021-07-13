package utils.sort;

import java.util.Arrays;
//归并排序
public class MergeSort {
    public void sort(int[] nums) {
        if (nums.length<2)//数组个数小于等于2个，则不需要排序
            return;
        //为了递归过程中，程序经常性的开辟数组空间，可以直接在递归开始就直接创建一个和原始数组一样大小的辅助数组
        int[]temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);//使用闭区间进行分割
    }

    /**
     *
     * @param nums
     * @param start 数组的起始位置
     * @param end 数组的终止位置
     * @param temp
     */
    private void mergeSort(int[] nums, int start, int end, int[] temp) {
        if (start<end){
            int mid = start + (end-start)/2;

            mergeSort(nums,start,mid,temp);//对数组左边部分进行归并
            mergeSort(nums,mid+1,end,temp);//对数组右边部分进行归并

            merge(nums,start,mid,end,temp);//将左右两边已经拍好序的辅助数组中的数据移动到原始数组中
        }
    }

    /**
     *
     * @param nums
     * @param start 需要归并的其实位置
     * @param mid 中间分隔索引
     * @param end
     * @param temp 辅助数组
     */
    private void merge(int[] nums, int start, int mid,int end, int[] temp) {
        /**
         * p1:左边数组的指针
         * p2:右边数组的指针
         * p:表示辅助数组的指针
         */
        int p1 = start,p2 = mid+1,p = 0;
        //开始归并数组
        while (p1<=mid && p2<=end){
            if (nums[p1] <= nums[p2]){//如果数组左边的元素小于数组右边的元素，先放左边的元素，升序排序
                temp[p++] = nums[p1++];
            }else //否则先放右边的元素
                temp[p++]=nums[p2++];
        }
        /**
         * 如果左边的元素没有归并完，也就是说还有剩余的元素没有放到辅助数组中，则继续放
         */
        while (p1<=mid){
            temp[p++]=nums[p1++];
        }
        /**
         * 如果数组右边的元素没有归并完，那么将右边的元素继续放到辅助数组中
         */
        while (p2<=end)
            temp[p++]=nums[p2++];

        /**
         * 将辅助数组中的元素拷贝到原始数组中
         */
        p=0;//重新将指针移动到数组头部
        while (start<=end)
            nums[start++]=temp[p++];
    }


    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 23, 10, 8, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
