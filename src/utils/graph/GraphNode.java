package utils.graph;

import utils.MyPrintFunction;

import java.util.*;

public class GraphNode {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (left <= right && top <= bottom) {
            //1 从(top, left) -> (top, right)
            for (int i = left; i <= right; i ++)
                ans.add(matrix[top][i]);
            //2 从(top + 1, right) -> (bottom, right)
            for (int i = top + 1; i <= bottom; i ++)
                ans.add(matrix[i][right]);
            if (top < bottom && left < right) {
                //3 从(bottom, right - 1) -> (bottom, left + 1)
                for (int i = right - 1; i > left; i --)
                    ans.add(matrix[bottom][i]);
                //4 从(bottom, left) -> (top - 1, left)
                for (int i = bottom; i > top; i --)
                    ans.add(matrix[i][left]);
            }


            left ++;
            top ++;
            right --;
            bottom --;
        }
        return ans;
    }

    public boolean canCross(int[] stones) {
        //使用暴力解法
        boolean [][] memo = new boolean[stones.length][stones.length];
        return can_cross(stones, 0, 0, memo); //第二个参数：当前所在的石子的索引， 第二参数：当前能跳的格子数
    }

    private boolean can_cross (int [] stones, int curIndex, int jumpSize, boolean [][] memo) {
        if (memo[curIndex][jumpSize])
            return true;
        for (int i = curIndex + 1; i < stones.length; i ++) {
            int gap = stones[i] - stones[curIndex];
            if (gap >= jumpSize - 1 && gap <= jumpSize + 1) {
                if (can_cross(stones, i, gap, memo)) {
                    memo[curIndex][jumpSize] = true;
                    return true;
                }
            }
        }

        return curIndex == stones.length - 1;
    }

    public static void main(String[] args) {
        int []  stones = {0,1,3,5,6,8,12,17};
        System.out.println(Arrays.binarySearch(stones, 0, 4, 6));
        System.out.println(new GraphNode().canCross(stones));
    }
}
