package hard;

import java.util.*;

public class NQuence {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> nQuence(int n) {
        if (n < 1)
            return res;
        int[] blank = new int[n];
        Arrays.fill(blank, -1);
        Set<Integer> usedCol = new HashSet<>();//用来记录剩下的皇后可以放置的列数
        Set<Integer> usedLine1 = new HashSet<>();//用来记录对角线是否可以放置皇后 从左上到右下 i-j=固定值
        Set<Integer> usedLine2 = new HashSet<>();//用来记录对角线是否可以放置皇后 从右上到左下 i+j=固定值
        backTrack(usedCol, usedLine1, usedLine2, 0, n, blank);

        return res;
    }

    private void backTrack(Set<Integer> usedCol, Set<Integer> usedLine1,
                           Set<Integer> usedLine2, int index, int n, int[] blank) {
        if (index == n) {
            List<String> path = getStr(blank, n);
            res.add(path);
        } else {
            for (int j = 0; j < n; j++) {
                if (usedCol.contains(j))
                    continue;
                int d1 = index - j;
                if (usedLine1.contains(d1))
                    continue;
                int d2 = index + j;
                if (usedLine2.contains(d2))
                    continue;
                blank[index] = j;
                usedCol.add(j);
                usedLine1.add(d1);
                usedLine2.add(d2);

                backTrack(usedCol, usedLine1, usedLine2, index + 1, n, blank);

                blank[index] = -1;
                usedCol.remove(j);
                usedLine1.remove(d1);
                usedLine2.remove(d2);
            }
        }
    }

    private List<String> getStr(int[] blank, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[blank[i]] = 'Q';
            res.add(new String(chars));
        }
        return res;
    }


    public List<List<String>> solveNQueens(int n){
        /**
         *nums表示棋盘，下标i表示行数，nuns[i]表示列数，从0开始计算
         */
        int []nums = new int[n];
        Arrays.fill(nums,-1);
        backTrack3(nums,0);
        return res;
    }

    /**
     *
     * @param nums: 期盼的行和列  nums的下标代表行，下标中存放的数据代表列，如：第i行第nums[i]列
     * @param row：当前的行数
     */
    private void backTrack3(int[]nums,int row){
        //1.退出条件
        if (row==nums.length){
            res.add(change(nums));
            return;
        }
        /**
         *
         */
        for (int col = 0; col < nums.length; col++) {//col代表列
            nums[row]=col;//表示第row行第col列已经放置了皇后，即第row行皇后所在的列
            /**
             * 将皇后放在第row行第col上看看，然后用isValid判断当前位置（row,col）上的皇后是否合法
             *  - 如果合法，则继续向下一行放置皇后
             *  - 如果不合法，则不放置，继续向下一列试探，以此类推
             */
            if (isValid(row,nums))//再检查第row是否可以放置，如果可以放置，则继续放置第row+1行
                backTrack3(nums,row+1);
        }

    }

    /**
     * 判断第row行是否可以放置皇后
     * @param row 行
     * @param nums 棋盘
     * @return
     */
    private boolean isValid(int row,int[]nums){
        for (int i = 0; i < row; i++) {//i表示row之前的行
            /**
             * 二维数组的对角线有如下规律：
             *        对角线上的元素的行下标之差的绝对值和列坐标之差的绝对值相等
             * 如果第row行已经放置了皇后，则不能再放了
             * nums[i]==nums[row]： 表示皇后在第i行所在的列和皇后在第row行所在的列相等，即他们会互相攻击，不合法
             * Math.abs(nums[row]-nums[i])==Math.abs(row-i)：表示第i行的皇后和第row行的皇后处在对角线上，也会互相攻击，不合法
             */
            if (nums[i]==nums[row] || Math.abs(nums[row]-nums[i])==Math.abs(row-i))
                return false;
        }
        return true;//表示皇后所处的位置合法
    }
    
    private List<String> change(int []nums){
        List<String> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            char[] chars = new char[nums.length];
            Arrays.fill(chars,'.');
            chars[nums[i]]='Q';
            r.add(new String(chars));
        }
        return r;
    }



    public static void main(String[] args) {
        int n = 4;
        NQuence quence = new NQuence();
        List<List<String>> res2 = quence.solveNQueens(n);
        System.out.println(res2.size() + "   " + res2);
    }
}
