package simple;

import java.util.Arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
//        for(int i =0;i<nums.length;i++){
//            for (int j = 0; j < nums.length-i-1; j++) {
//                if (nums[j]==0){
//                    int t = nums[j+1];
//                    nums[j+1]=nums[j];
//                    nums[j]=t;
//                }
//            }
//        }
        int j=0;//表示第一个0所在的下标
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i]!=0){
                int t = nums[j];
                nums[j]=nums[i];
                nums[i]=t;
                j++;
            }
            System.out.println("i="+i+",j="+j+" "+Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[]nums={0,5,6,7,0,1,2,0,2,3,12};
        System.out.println(Arrays.toString(nums));
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
