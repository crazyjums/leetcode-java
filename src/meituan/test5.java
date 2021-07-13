package meituan;

import java.util.Scanner;

public class test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input[]=scanner.nextLine().split(" ");
        int A=Integer.parseInt(input[0]),B=Integer.parseInt(input[1]),
                C=Integer.parseInt(input[2]),n=Integer.parseInt(input[3]);

        int [][]nums = new int[n][2];
        int []res=new int[n];

        for (int i = 0; i < n; i++) {
            //左上角
            int x = (int)Math.sqrt(nums[i][0]);
            if (nums[i][0] + 1 >= ((2^x)) && nums[i][0] +1 <=2*(2^x) && nums[i][1] +1 >= (2^x)  &&nums[i][1]+1<=2*(2^x)){
                 res[i] = 2^((int)Math.sqrt(nums[i][0]));
                 //右上角
            }else if (nums[i][0] + 1 >=(2^x) && nums[i][0] +1 <=2*(2^x) && nums[i][1] +1 >=3*(2^x)  &&nums[i][1]+1<=4*(2^x)){
                res[i] = A + 2^((int)Math.sqrt(nums[i][0]));
                //左下角
            }else if(nums[i][0] + 1 >3*(2^x) && nums[i][0] +1 <=4*(2^x) && nums[i][1] +1 >(2^x)  &&nums[i][1]+1<=2*(2^x)){
                res[i] = B+ 2^((int)Math.sqrt(nums[i][0]));
                //右下角
            }else if (nums[i][0] + 1 >3*(2^x) && nums[i][0] +1 <=4*(2^x) && nums[i][1] +1 >3*(2^x)  &&nums[i][1]+1<=4*(2^x)){
                res[i] = C+2^((int)Math.sqrt(nums[i][0]));
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }
}
