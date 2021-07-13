package hard;

/*
import java.util.Scanner;

public class Main {

    static long ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
           nums[i] = sc.nextInt();
        }
        int[]temp = new int[n];
        mergerSort(nums, 0, nums.length - 1,temp);
        System.out.println(ans);
    }

    public static void mergerSort(int[] nums, int l, int r,int[]temp) {
        if (l >= r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergerSort(nums, l, m,temp);
        mergerSort(nums, m + 1, r,temp);
        if(nums[m] >= nums[m+1]) {
            merger(nums, l, m, r,temp);
        }
    }

    private static void merger(int[] nums, int l, int m, int r,int[]temp) {
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (nums[i] > nums[j]) {
                // 产生了 j-i+1 对逆序对
                int t = i;
                while(t <= m) {
                    ans += (nums[t++] - nums[j]);
                }
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while(i <= m) {
            temp[k++] = nums[i++];
        }
        while(j <= r) {
            temp[k++] = nums[j++];
        }
        k=0;
        while(l<=r)
            nums[l++] = temp[k++];
    }
}
*/
import java.util.*;

public class ReversePairsSum{
    private static int sum = 0;

    public static void main(String []argv){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int temp []= new int[a.length];
        mergeSort(0,a.length-1,a,temp);
        System.out.println(sum);
    }

    private static void mergeSort(int start,int end,int[]nums,int[]temp){
        if(start>=end)
            return ;
        int mid = start + (end-start)/2;
        mergeSort(start,mid,nums,temp);
        mergeSort(mid+1,end,nums,temp);
        if(nums[mid]>=nums[mid+1])
            mergeCross(start,mid,end,nums,temp);
    }

    private static void mergeCross(int start,int mid, int end, int[]nums,int[] temp){
        int p1 = start, p2 = mid+1, p = 0;
        while(p1<=mid && p2 <= end){
            if(nums[p1] <= nums[p2]){
                temp[p++] = nums[p1++];
            }
            else{
                int t = p1;
                while(t<=mid)
                    sum += (nums[t++] - nums[p2]);
                temp[p++] = nums[p2++];
            }
        }
        while(p1<=mid){
            temp[p++] = nums[p1++];
        }
        while(p2<=end)
            temp[p++] = nums[p2++];
        p = 0;
        while(start<=end)
            nums[start++] = temp[p++];
    }
}
