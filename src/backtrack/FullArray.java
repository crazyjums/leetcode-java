package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列，给定一个数组，数组中的元素各不相同，求所有可能的组合
 */
public class FullArray {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> solution(int[] nums) {
        List<Integer> path = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        dfs(nums, path, used);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        //退出条件
        /**
         * 当枚举数组中的个数等于原数组的个数时，结束
         */
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        /**
         * 当前逻辑
         */
        for (int i = 0; i < nums.length; i++) {
            //如果当前数字没有出现在枚举可能中，则添加到path中
            if (!used[i]){
                path.add(nums[i]);
                used[i]=true;
                //继续遍历
                dfs(nums,path,used);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> res = new FullArray().solution(nums);
        System.out.println(res);
    }


}
