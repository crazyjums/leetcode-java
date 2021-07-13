package test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int c=0;
        while (n!=0){
            c++;
            n = n &(n-1);
        }
        System.out.println(c);
    }
}
