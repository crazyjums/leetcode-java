package simple;

import utils.MyPrintFunction;

public class findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int n = nums.length;
        int l = 0, r = l + 1;
        int res = 1;
        int max = res;
//        while (l<r&&r<n){
//            if (nums[l]<nums[r]){
//                res++;
//                max = Math.max(res,max);
//                l++;
//                r++;
//            }else{
//                res=1;
//                max = Math.max(res,max);
//                l++;
//                r++;
//            }
//
//        }
        //简化版
//        while (l < r && r < n) {
//            if (nums[l] < nums[r])
//                res++;
//            else
//                res = 1;
//
//            max = Math.max(res, max);
//            l++;
//            r++;
//        }
        for (int i = 0; i < n-1; i++) {
            if (nums[i]<nums[i+1])
                res++;
            else
                res=1;
            max = Math.max(res,max);
        }
        return max;
    }

        public static void main (String[]args){
            int[] nums = {1,3,5,4,7};
            int res = new findLengthOfLCIS().findLengthOfLCIS(nums);
            System.out.println(res);
        }
    }
