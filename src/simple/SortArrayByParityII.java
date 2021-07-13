package simple;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII {
    public int sortArrayByParityII(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public static int nPeople(int n) {
        int count =  n;
        int p = 0;
        boolean[] a = new boolean[n];
        while (count > 1) {
            for (int i = 0; i < n; i++) {
                if (!a[i]) p++;
                if (p == 3) {
                    a[i] = true;
                    count --;
                    p = 0;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!a[i])
                res = i +  1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SortArrayByParityII().sortArrayByParityII("godding","gd"));
        String s = "spa";
        System.out.println(nPeople(16));
    }
}
