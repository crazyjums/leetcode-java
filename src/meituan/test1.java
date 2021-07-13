package meituan;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] line1 = input.split(" ");
        int p = Integer.parseInt(line1[1]);
        int q = Integer.parseInt(line1[2]);
        int [] a = new int[p];
        int []b=new int[q];
        String as[] =scanner.nextLine().split(" ");
        for (int i = 0; i < p; i++) {
            a[i] = Integer.parseInt(as[i]);
        }
        String bs[] = scanner.nextLine().split(" ");
        for (int i = 0; i < q; i++) {
            b[i]=Integer.parseInt(bs[i]);
        }
        int[][]dp=new int[p+1][q+1];
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= q; j++) {
                if (a[i-1]==b[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        System.out.println((p-dp[p][q])+" "+" "+(q-dp[p][q])+" " + dp[p][q]);
    }

}
