package interview;

import java.util.Scanner;

public class Test {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println("input:  " +line);

//        char[] chars = line.toCharArray();
//
//        for (int i = 0; i < chars.length - 1; i++) {
//            for (int j = 0; j < chars.length - i - 1; j++) {
//                if (chars[j] > chars[j + 1]) {
//                    char ch = chars[j];
//                    chars[j] = chars[j + 1];
//                    chars[j + 1] = ch;
//                }
//            }
//        }
//
//        System.out.println(String.valueOf(chars));


        int chars = 0;
        int spaces = 0;
        int numbers = 0;
        int others = 0;

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numbers ++;
            } else if (ch >= 'a' && ch <= 'z') {
                chars ++;
            } else if (ch >= 'A' && ch <= 'Z') {
                chars ++;
            } else if (ch == ' ') {
                spaces ++;
            } else
                others ++;
        }

        System.out.println("英文字母: " + chars);
        System.out.println("空格: " + spaces);
        System.out.println("数字: " + numbers);
        System.out.println("其他字符: " + others);
    }
}
