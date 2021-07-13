package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[]used = new boolean[nums.length];
        backTrack(nums,used,path);
        return res;
    }

    private void backTrack(int[] nums, boolean[] used, List<Integer> path) {
        //递归，退出条件
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //当前逻辑 对数组中每个数试一次
        for (int i = 0; i < nums.length; i++) {
            /**
             * 可以将此思路当成是由nums.length个空格，从nums数组中选择数字填到这些空格中，
             * 从左往右，在填右边这个元素时，要先判断一下左边的元素是否被用过，如果没有被用过，那
             * 左边的元素是否和右边待填的元素相等
             */
            if (i>0 && nums[i]==nums[i-1]&&!used[i-1] )
                continue;
            if (!used[i]){
                used[i]=true;
                path.add(nums[i]);
                backTrack(nums,used,path);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[]nums={1,2,1};
        List<List<Integer>> res = new permuteUnique().permuteUnique(nums);
        MyPrintFunction.print(res);
    }
}
