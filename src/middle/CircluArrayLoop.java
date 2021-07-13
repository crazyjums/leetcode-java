package middle;

public class CircluArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        if (nums.length<=1)return false;
        boolean[] isVisited=new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]*nums[nums[i]] < 0)
                return false;

            int next = (i+nums[i])%nums.length;

        }
        return true;
    }


    public static void main(String[] args) {
        int [] nums={2,-1,1,2,2};
        boolean res = circularArrayLoop(nums);
        System.out.println(res);
    }
}
