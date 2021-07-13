package meituan;

import utils.MyPrintFunction;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input);
        input = scanner.nextLine();
        String [] s = input.split(" ");
        int[]a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(s[i]);
        }
        if (n!=(2^(n-1)))
            System.out.println("NO");
        else{

        }

    }
}
