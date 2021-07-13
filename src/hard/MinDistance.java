package hard;

import utils.MyPrintFunction;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        /**
         * 思路：
         * 使用动态规划的思路解题：
         *      建立一个dp table，多行和列都多一行，代表从一个空字符串如何转变成另一个字符串，
         *      或者如果从另一个字符串如何转变成一个空字符串，
         *      dp[i][j]表示word1[1...i]转变成word2[1...j]所需要的的最小编辑距离
         * 需要注意状态如何转移，有两种状态，（单词的索引从1开始）
         *   - word1[i-1]==word2[j-1]，因为求最小编辑距离，所以此时不需要进行修改，直接跳过即可，此时dp[i][j]=dp[i-1][j-1]
         *   - word1[i-1]!=word2[j-1]，此时有三种情况可以让word1[i-1]和word2[j-1]变得相等：
         *      - 删除一个字符，即dp[i][j]=dp[i-1][j]+1
         *      - 添加一个字符，即dp[i][j]=dp[i][j-1]+1
         *      - 替换一个字符，即dp[i][j]=dp[i-1][j-1]+1
         */
        int n1 = word1.length();//行
        int n2 = word2.length();//列
        int[][]dp=new int[n1+1][n2+1];
        //给第0行赋值，表示一个空字符串变成word2所需要的最小编辑距离，那就只能添加字符
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = i;
        }
        //给第0列赋值，表示word1变成一个空字符串所需要的最小编辑距离，那就只能删除字符
        for (int i = 0; i <= n1; i++) {
            dp[i][0]=i;
        }
        MyPrintFunction.print(dp);
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
            }
        }
        MyPrintFunction.print(dp);
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adc";
        int res = new MinDistance().minDistance(s1,s2);
        System.out.println(res);
    }
}
