package middle;

import java.util.Arrays;

public class LengthOfLTS {
    public static int solution1(int []nums){
        int n = nums.length;
        if (n<=1)
            return n;
        int[]res=new int[n];
        res[0]=1;
        int c=1;
        for (int i = 1; i < n; i++) {
            res[i]=1;
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j])
                    res[i] = Math.max(res[i],res[j]+1);
            }
            c=Math.max(res[i],c);
        }
        return c;
    }

    public static void main(String[] args) {
        int[]nums={10,9,2,5,3,7,101,18};
        int res = solution1(nums);
        System.out.println(res);
    }
}
