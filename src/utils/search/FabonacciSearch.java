package utils.search;

import java.util.Arrays;

public class FabonacciSearch {
    public boolean search(int []nums,int target){
        int n=nums.length;
        if (n==0)
            return false;
        int []f=new int[20];
        Fabonacci(f,20);
        int k=0;
        while (n>f[k]-1)
            ++k;
        int []nums2=new int[f[k]];
        System.arraycopy(nums,0,nums2,0,n);
        for (int i = n; i < f[k]; i++) {
            nums2[i]=nums[n-1];
        }

        int l=0,r=f[k]-1;
        while (l<=r){
            int mid = l+f[k]-1;
            if(nums2[mid]>target){
                r=mid-1;
                k-=2;
            }else if(nums2[mid]<target){
                l=mid+1;
                k-=1;
            }else{// if (nums2[mid]==target)
                if (mid>=n){//说明在加长的数组里面，即最后一个元素
                    return true;
                }else{//说明mid小于数组长度，直接返回mid的值
                    return true;
                }
            }
        }
        return false;
    }

    public void Fabonacci(int []f,int size){
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < size; i++) {
            f[i]=f[i-1]+f[i-2];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i + 1;
        }
        FabonacciSearch fabonacciSearch = new FabonacciSearch();
        for (int i = 1; i < 25; i++) {
            System.out.println(i+"  "+fabonacciSearch.search(nums, i));
        }
    }
}
