package meituan;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input0 = scanner.nextLine();
        int n = Integer.parseInt(input0);
        input0 = scanner.nextLine();
        String []input = input0.split(" ");
        int []a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        int []b=new int[n];
        for (int i = 0; i < n; i++) {
            b[i]=a[i];
            for (int j = 0; j < n; j++) {
                b[i] ^= ((i+1)%(j+1));
            }
        }
        int res = b[0];
        for (int i = 1; i < n; i++) {
            res ^= b[i];
        }
        System.out.println(res);
    }
}
