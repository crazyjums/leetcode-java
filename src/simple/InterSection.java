package simple;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterSection {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1=0,p2=0;
        int pre = 0;
        while(p1<n1&&p2<n2){
            if(nums1[p1]==nums2[p2] && nums1[p1]!=pre){
                res.add(nums1[p1]);
                pre = nums1[p1];
            }else if (nums1[p1] < nums2[p2])
                p1++;
            else
                p2++;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[]nums1={1,2,2,1};
        int[]nums2={2,2};
        int[]res=new InterSection().intersection(nums1,nums2);
        MyPrintFunction.print(res);
    }
}
