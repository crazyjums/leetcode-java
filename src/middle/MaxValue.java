package middle;

import utils.MyPrintFunction;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++)//填充第0行
            dp[0][i] = grid[0][i] + dp[0][i - 1];

        for (int i = 1; i < row; i++)//填充第0列
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        MyPrintFunction.print(dp);
        for (int i = 1; i < row; i++)
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }

        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MaxValue maxValue =new MaxValue();
        int res  = maxValue.maxValue(grid);
        System.out.println(res);
    }
}
