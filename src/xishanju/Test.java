package xishanju;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public int[] getdp(int[] arr){
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0 ;
        int r = 0;
        int m = 0;
        for(int i = 1;i <arr.length;i++){
            l = 0;
            r= right;
            while(l<=r){
                m = (l +r )/2;
                if(arr[i]<ends[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }
            right = Math.max(right,l);
            ends[l] = arr[i];
            dp[i] = l+1;
        }

        return dp;
    }

    public int[] lis(int[] nums) {
        if (nums.length == 1) return new int[0];
        if (nums.length == 0) return new int[0];

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
//        for (int i = 0; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//                max = Math.max(dp[i], max);
//            }
//        }
        int right=0;//表示有效的LIS的长度
        int ends[]=new int[nums.length];//ends[i]表示长度为i的LIS的末尾元素的最小值
        ends[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int l=0,r=right;
            while (l<=r){
                int mid = l +((r-l)>>1);
                if(nums[i] > ends[mid])
                    l = mid + 1;
                else r = mid - 1;
            }
            right = Math.max(right,l);
            ends[l] = nums[i];
            dp[i] = l + 1;
        }
        MyPrintFunction.print(dp);
        MyPrintFunction.print(ends);
        int index = 0;//dp数组中的最大值所在索引
        int len = 0;//dp数组中的最大值，即整个数组的最长上升子序列
        for(int i=0;i<dp.length;i++){
            if (dp[i] > len){ //找到dp数组中的最大值以及索引
                len = dp[i];
                index = i;
            }
        }
        int list[]=new int[len];
        for(int i = index;i>=0;i--){
            if (dp[i] == len){
                list[--len] = nums[i];
            }
        }
        return list;
    }

    public int[] getLIS(int[] nums){
        int n = nums.length;
        int []dp=new int[n];
        dp[0]=1;
        int []ends = new int[n];
        int maxlen = 1;
        int maxindex = 0;
        int right = 0;
        int l,r,mid;
        ends[0] = nums[0];
        for(int i=1;i<n;i++){
            l = 0;
            r = right;
            while (l<=r){
                mid = (r+l)/2;
                if (nums[i] < ends[mid]) r=mid-1;
                else l=mid+1;
            }
            right = Math.max(right,l);
            ends[l] = nums[i];
            dp[i] = l+1;
            if (dp[i]>=maxlen){
                maxlen=dp[i];
                maxindex=i;
            }
        }
        int [] res = new int[maxlen];
//        res[--maxlen] = nums[maxindex];
//        for(int i=maxindex;i>-1;i--){
//            if (nums[maxindex] > nums[i] && dp[maxindex] == dp[i]+1)
//            {
//                res[--maxlen] = nums[i];
//                maxindex = i;
//            }
//        }
        for(int i = maxindex;i>=0;i--){
            if(dp[i] == maxlen)
                res[--maxlen] = nums[i];
        }

        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k <= 0 || input == null || input.length == 0) return res;
        if (k > input.length) {
//            for (int i = 0; i < input.length; i++)
//                res.add(input[i]);
            return res;
        }

        int l = 0, r = input.length - 1;
        int mid = partition(l , r, input);
        while (mid != k - 1) {
            if (mid > k - 1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            mid = partition(l , r, input);
        }
        for (int i = 0; i < k; i ++)
            res.add(input[i]);
        return res;
    }

    private int partition(int left, int right, int[] nums) {
        int pv = nums[left];
        int l = left, r = right;
        while (l != r) {
            while (l < r && nums[r] >= pv) r--;
            while (l < r && nums[l] <= pv) l ++;
            if (l < r) {
                nums[l] = nums[l] ^ nums[r];
                nums[r] = nums[l] ^ nums[r];
                nums[l] = nums[l] ^ nums[r];
            }
        }
        nums[left] = nums[l];
        nums[l] = pv;
        return l;
    }

    public String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str1.equals("") || str2 == null || str2.equals(""))
            return "0";
        int n1 = str1.length();
        int n2 = str2.length();

        int len = 0;
        int index = 0;
        int max = 0;
        int row = 0, col = n2 - 1;
        while (row < n1) {
            int i = row, j = col;
            while (i < n1 && j < n2) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    len ++;
                    if (len > max) {
                        max = len;
                        index = i;
                    }
                } else
                    len = 0;
                i ++;
                j ++;
            }
            if (col > 0) col --;
            else row ++;
        }

        System.out.println(index+ " " + max);
        return str1.substring(index - max + 1, index + 1);
    }
    public static void main(String[] args) {
        Test test = new Test();
        int[] nums = {4,5,1,6,2,7,3,8};
        List<Integer> res = new Test().GetLeastNumbers_Solution(nums,8);
        MyPrintFunction.print(res);
        String lis = test.LCS("", "");
        System.out.println(lis);

        StringBuilder sb = new StringBuilder();
        sb.append('5' + '6' - '9' - '1');
        sb.append('5' + '6' - '9' - '1');
        System.out.println(sb.toString());
        System.out.println('5' + '6' - '9' - '1');
        String s = "aa";

    }
}
