package middle;

import utils.MyPrintFunction;

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int p = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
//                int t = nums[i];
//                nums[i] = nums[p];
//                nums[p] = t;
                swap(nums,i,p);
                p++;
            }
        }
        for (int i = p; i < n; i++) {
            if (nums[i] == 1) {
//                int t = nums[i];
//                nums[i] = nums[p];
//                nums[p] = t;
                swap(nums,i,p);
                p++;
            }
        }
    }

    private void swap(int []nums, int i,int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public void sortColors2(int[] nums) {
//        int n = nums.length;
//
//        int p0=0,p1=0;
//
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 1){
//                swap(nums, i, p1);
//                p1++;
//            }else if (nums[i] == 0){
//                swap(nums, i, p0);
//                if (p0<p1){
//                    swap(nums, i, p1);
//                }
//                p0++;
//                p1++;
//            }
//        }


        int n = nums.length;
        int p0=0,p2=n-1;
        for (int i = 0; i <= p2; i++) {
            while (i<=p2 && nums[i] ==2 ){
                swap(nums,i,p2);
                p2--;
            }
            if (nums[i]==0){
                swap(nums,i,p0);
                p0++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,1};
        SortColors sortColors = new SortColors();

        sortColors.sortColors2(nums);
        MyPrintFunction.print(nums);

        int[]numss = {1,2,0,2,1,0};
        sortColors.sortColors2(numss);
        MyPrintFunction.print(numss);

    }
}
