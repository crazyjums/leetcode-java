package simple;

import java.util.Arrays;

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

 

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeArray {
    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int [] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        System.arraycopy(nums2,0,nums1,3,3);
        mergeArray.solution3(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));

    }
    public void solution1(int[] nums1,int m, int[] nums2,int n){
        for (int i = m; i < m+n; i++) {
            nums1[i]=nums2[i-m];
        }
        for (int i = 0; i < m+n-1; i++) {
            for (int j = 0; j < m+n-i-1; j++) {
                if (nums1[j] > nums1[j+1]){
                    int tem = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1]=tem;
                }
            }
        }
    }
    public void solution2(int[] nums1,int m, int[] nums2,int n){
        int [] temps=new int[m];
        System.arraycopy(nums1,0,temps,0,m);
        int i=0,j=0,k=0;
        while ((i<m)&&(j<n)){
            nums1[k++] = (temps[i] > nums2[j]) ? nums2[j++] : temps[i++];
        }
        if (i<m)
            System.arraycopy(temps,i,nums1,k,m-i);
        if (j<n)
            System.arraycopy(nums2,j,nums1,k,n-j);
    }

    public void solution3(int[] nums1,int m, int[] nums2,int n){
        int p1=m-1,p2=n-1,p3=m+n-1;
        while (p1>=0&&p2>=0){
            if (nums1[p1]>=nums2[p2]){
                nums1[p3--]=nums1[p1--];
            }else if(nums1[p1]<nums2[p2]){
                nums1[p3--]=nums2[p2--];
            }
        }
        while (p1<0&&p2>=0){
            nums1[p3--]=nums2[p2--];
        }
    }
}
