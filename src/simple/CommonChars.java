package simple;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommonChars {
    public static List<String> commonChars(String[] A) {
        int n = A.length;
        if (n == 0)
            return null;
        int[] hs = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            hs[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < n; i++) {
            int[] t = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                t[A[i].charAt(j) - 'a']++;

            }
            for (int k = 0; k < 26; k++) {
                hs[k] = Math.min(hs[k], t[k]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < hs[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        String[] a = {"hello", "locel", "roller"};
//        String[] a ={"aaaaabbbbbc","abc","aaaabbbdddc"};
        String[] a ={"hello", "ll"};
        List<String> res;// = new ArrayList<>();
        res = commonChars(a);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
