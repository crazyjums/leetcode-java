package middle;

import utils.MyPrintFunction;

import java.util.Arrays;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * 思路：
         *      根据没有障碍物的走法：f(m,n)=f(m-1,n)+f(m,n-1)，f(m,n)表示从左上角格子走到[m,n]的格子的所有走法
         *      当遇到有障碍物时，便表示此路不通，那么到障碍物这一格子的走法便是0，其他的格子走法路径不变
         */
        int m = obstacleGrid.length;
        if (m==0)return 0;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //整个矩形
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i]!=1)
                dp[0][i]=1;
            else break;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0]!=1)//不是障碍物，则可以过去
                dp[i][0] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j]==0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else dp[i][j]=0;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] path = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][]p ={{0,0}};
        int res = new UniquePathsWithObstacles().uniquePathsWithObstacles(p);
        System.out.println(res);
    }
}

