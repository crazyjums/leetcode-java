package niuke;

import java.util.*;
import java.io.*;
public class LIS{
    public static  void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] res = getResult(arr);
        for(int j = 0 ;j<res.length;j++){
            System.out.print(res[j]+" ");
        }
    }




    public static int[] getResult(int[] arr){
        if(arr==null||arr.length==0) return arr;
        int[] dp = getdp(arr);
        return getList(arr,dp);
    }


    public static int[] getdp(int[] arr){
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



    public static int[] getList(int[] arr, int[]dp){
        int len = 0 ;
        int index = 0 ;
        for(int i = 0 ; i <dp.length;i++){
            if(dp[i]>=len){
                len = dp[i];
                index = i;
            }
        }
        int[] result = new int[len];
        len--;
        result[len] =  arr[index];

        for(int i = index ; i >=0;i--){
            if(arr[i]<arr[index] && dp[i] == dp[index] -1){
                len--;
                result[len] = arr[i];

                index = i ;
            }
        }
        return result;
    }

}
