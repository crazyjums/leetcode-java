package meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Character> big = new ArrayList<>();
        List<Character> small = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >='A' && input.charAt(i) <= 'Z')
                big.add(input.charAt(i));
            else if (input.charAt(i) >='a' && input.charAt(i)<='z')
                small.add(input.charAt(i));
        }
        int change = Math.abs(big.size()-small.size());
        System.out.println(change/2);

    }
}
