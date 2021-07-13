package hard;

import utils.MyPrintFunction;

public class UniquePathsIII {
    private int row;
    private int col;
    private int[][]grid;
    private int canVisitSpace=0;
    private int totalPath=0;
    private int[][]nextGrid={{-1,0},{1,0},{0,-1},{0,1}};//分别代表上、下、左、右

    public int uniquePathsIII(int[][] grid) {
        /**
         * 思路：
         *      采用回溯算法对整个数组中能够被访问的格子进行遍历，记录所有符合要求的路径数，
         *      回溯访问时，需要对已经访问的格子加上一个障碍物，表示该格子已经被访问过了，
         *      防止被重复访问，当回溯回来时，再将障碍物拿开。继续搜索其他的格子（上下左右）
         */
        this.grid=grid;
        row = grid.length;
        col = grid[0].length;
        int starti=0;
        int startj=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]==1){
                    starti=i;
                    startj=j;
                }else if (grid[i][j]==0)
                    canVisitSpace++;
            }
        }
        canVisitSpace++;//起始位置也是一个可以访问的格子
        int visitedCount = 0;
        dfs(starti,startj,visitedCount);
        return totalPath;
    }

    private void dfs(int r, int c, int visitedCount) {
        if (this.grid[r][c]==2){
            if (visitedCount==canVisitSpace)
                totalPath++;
            return;
        }
        this.grid[r][c]=-1;//放置一个障碍物，防止重复访问
        for (int[] pos:nextGrid) {
            int nextr = r+pos[0];
            int nextc=c+pos[1];
            if (isValid(nextr,nextc))
                dfs(nextr,nextc,visitedCount+1);
        }
        this.grid[r][c]=0;
    }

    private boolean isValid(int nextr, int nextc) {
        if (nextr<0||nextr>row)return false;
        if (nextc<0||nextc>col)return false;
        if (nextr<row&&nextc<col){
            int val = this.grid[nextr][nextc];
            if (val==-1)return false;
            if (val==2)return true;
            if (val==0)return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] path = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int[][]path={{1,2}};
        int res = new UniquePathsIII().uniquePathsIII(path);
        System.out.println(res);
    }
}
