package utils.sort;

import utils.MyPrintFunction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuickSort2 {
    public void sort(int []nums){
        doubleRound(0,nums.length-1,nums);
    }
    //左闭右闭区间
    private void doubleRound(int left, int right, int []nums){
        if(left>=right)
            return;
        int pIndex = partition(left,right,nums);//得到基准元素的下标
        doubleRound(left,pIndex-1,nums);//左闭右闭区间
        doubleRound(pIndex+1,right,nums);//左闭右闭区间
    }
    private int partition(int left, int right, int []nums){
        int pValue = nums[left], l = left, r = right;
        while(l!=r){
            while(l<r && nums[r] >= pValue)
                r--;
            while(l<r && nums[l] <= pValue)
                l++;
            if(l<r){
                nums[l] = nums[l] ^ nums[r];
                nums[r] = nums[l] ^ nums[r];
                nums[l] = nums[l] ^ nums[r];
            }
        }
        nums[left] = nums[l];
        nums[l] = pValue;
        return l;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("11");
        set.add("11");
        set.add("33");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        int[] nums={6,4,10,23,19,8,9};
        QuickSort2 quickSort2 = new QuickSort2();
        quickSort2.sort(nums);
        MyPrintFunction.print(nums);

    }
}
