package backtrack;

import utils.A;
import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class permuteUnique {
    private HashSet<List<Integer>> set = new HashSet<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        dfs(nums,used,path);
        for (List<Integer> each: set) {
            res.add(each);
        }
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> path) {
        if (path.size()==nums.length){
            set.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i]=true;
                dfs(nums,used,path);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        int []nums ={1,2,1};
        List<List<Integer>> res = new permuteUnique().permuteUnique(nums);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
