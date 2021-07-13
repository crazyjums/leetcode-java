package hard;

public class TotalNQueens {
    private int res = 0;
    public int totalNQueens(int n){
        int [] nums = new int[n];
        baclTrack(nums,0);
        return res;
    }

    private void baclTrack(int[] nums,int row){
        if (nums.length==row){
            res++;
            return;
        }
        for (int col = 0; col < nums.length; col++) {
            nums[row] = col;//先假设 第row行和第col列可以放皇后，然后判断这样放置是否合法
            if (isValid(nums,row))//如果这样放合法，那么继续放第row+1行的皇后
                baclTrack(nums,row+1);
        }
    }

    /**
     * 判断第row行是否有可以放置皇后个格子
     * @param nums
     * @param row
     * @return
     */
    private boolean isValid(int []nums,int row){
        for (int i = 0; i < row; i++) {
            /**
             * 如果在对角线上或是与已经放置的皇后在同一行或列上，都是false
             * 对角线上的元素，行索引的绝对值和列索引的绝对值相等
             *
             * - 与皇后在同一对角线上的格子不能放置皇后
             * - 与皇后在同一行的格子不能放置皇后
             * - 与皇后在同一列的格子不能放置皇后
             */
            if (Math.abs(row-i) == Math.abs(nums[row] - nums[i]) || nums[i]==nums[row])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=3;
        TotalNQueens totalNQueens = new TotalNQueens();
        System.out.println(totalNQueens.totalNQueens(n));
    }
}
