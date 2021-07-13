package simple;

public class MaxSubArray {
    public static int solution(int []nums){
        int res=nums[0];
        if (nums.length==0)
            return res;
        if (nums.length==1)
            return nums[0];
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i],max+nums[i]);
            res = Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums={-2,-1};//,-3,4,-1,2,1,-5,4};
        int res = solution(nums);
        System.out.println(res);
    }
}
