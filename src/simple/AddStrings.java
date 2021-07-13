package simple;

import java.util.HashMap;
import java.util.Map;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1 = num1.length();
        int n2 = num2.length();
        int i = n1 - 1, j = n2 - 1;
        int f = 0;
        while (i >= 0 || j >= 0) {
            int c1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int added = c1 + c2 + f;
            if (added > 9) {
                f = 1;
                sb.append(added % 10);
            } else {
                sb.append(added);
                f = 0;
            }
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String n1 = "1234";
        String n2 = "99";
        System.out.println(new AddStrings().addStrings(n1, n2));
        Map<Integer, Integer > map = new HashMap<>();
//        Map.Entry<Integer, Integer> e;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

        }
    }
}
