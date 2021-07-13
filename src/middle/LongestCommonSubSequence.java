package middle;

import utils.MyPrintFunction;

public class LongestCommonSubSequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        /**
         * 用动态规划求解子问题，
         * 其本质就是填一个二维数组或者一个一维数组
         */
        int n1 = text1.length();//计算字符串的长度
        int n2 = text2.length();//字符串的长度
        /**
         * dp[i][j]
         *  - 表示字符串s1从第一个字符到第i个字符与字符串s2中第1个字符到第j个字符的最长公共子序列的长度，都是闭区间，
         */
        int[][] dp = new int[n1 + 1][n2 + 1];//将字符串为""考虑进来，所以行和列都大1
        for (int i = 1; i <= n1; i++) { //从第第一个不为""的字符开始比较
            for (int j = 1; j <= n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {//如果当前两个字符相等，则最长长度+1
                    dp[i][j] = dp[i - 1][j - 1] + 1;//则最长长度+1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);//如果不相等，则是其前一个长度的最大值
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        int res = longestCommonSubsequence(s1, s2);
        System.out.println(res);
    }
}
