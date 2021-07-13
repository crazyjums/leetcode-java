package middle;

import java.util.*;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null | s2 == null || s1.length() > s2.length()) return false;
        int len = s1.length();
        if (len == 0) return true;

        int[] need = new int[26];
        int[] res = new int[26];

        for (int i = 0; i < len; i++) {
            need[s1.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i <= s2.length() - len; i++) {
            for (int j = i; j < i + len; j++) {
                res[s2.charAt(j) - 'a'] ++;
            }

            if (Arrays.equals(need,res))
                return true;
            Arrays.fill(res,0);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean res = checkInclusion.checkInclusion(s1, s2);
        System.out.println(res);

        System.out.println(Math.random() * 200);
        List<Integer>  a = new ArrayList<>();
        int c = 11;
        System.out.println((c^1) + " " + ~c);
    }
}
