package niuke;

import utils.MyPrintFunction;

public class LCSS {
    private static int[][] getDP (String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return new int[0][];
        int [][] dp = new int[s1.length()][s2.length()];
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 0; i < s2.length(); i ++) {
            dp[0][i] = s1.charAt(0) == s2.charAt(i) ? 1 : 0;
        }
        for (int i = 0; i < s1.length(); i ++) {
            dp[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
        }
        int max = 0;
        for (int i = 1; i < s1.length(); i ++) {
            for (int j = 1; j < s2.length(); j ++) {
                int r = i, c = j, count = 0;
                while (r >= 0 && c >= 0) {
                    if (s1.charAt(r) == s2.charAt(c)) {
                        count ++;
                        r --;
                        c --;
                    } else
                        break;
                }
                dp[i][j] = count;
                max = Math.max(max, dp[i][j]);
            }
        }
        return dp;
    }

    private static String getLCSS(String s1, String s2) {
        int[][] dp = getDP(s1, s2);
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] > max)
                    max = dp[i][j];
            }
        }
        char[] ans = new char[max];

        int row = dp.length;
        int col = dp[0].length;
        int index = ans.length - 1;
        for (int i = row - 1; i > -1; i--) {
            for (int j = col - 1; j > -1; j--) {
                if (dp[i][j] == max) {
                    int r = i;
                    while (index >= 0){
                        ans[index --] = s1.charAt(r);
                        r --;
                    }
                    break;
                }
            }
        }
        return String.valueOf(ans);
    }

    public static String getLCSS2 (String s1, String s2) {
        int[][] dp = getDP(s1, s2);
        int max = 0;
        int endIndex = 0;
        for (int i = 0; i < s1.length(); i ++) {
            for (int j = 0; j < s2.length(); j ++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    endIndex = i;
                }
            }
        }
        return s1.substring(endIndex - max + 1, endIndex + 1);
    }

    public static String getLCSS3 (String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int max = 0;
        int endIndex = 0;
        int len = 0;
        int r = 0;
        int c = n2 - 1;
        while (r < n1) {
            int i = r;
            int j = c;
            len = 0;
            while (i < n1 && j < n2) {
                if (s1.charAt(i) == s2.charAt(j))
                    len ++;
                else
                    len = 0;
                if (len > max) {
                    max = len;
                    endIndex = i;
                }
                i++;
                j++;
            }
            if (c > 0)
                c --;
            else
                r ++;
        }
        return s1.substring(endIndex - max + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "1AB2345CD";
        String s2 = "12345EF";
        int[][]dp = getDP(s1,s2);
        MyPrintFunction.print(dp);
        String res = getLCSS3(s1,s2);
        System.out.println(res);
    }
}
