package middle;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if (n == 0) return res;
        boolean[] used = new boolean[n];//默认都是false
        List<Integer> path = new ArrayList<>();
        backTrack2(path, nums);
        return res;
    }

    //递归调用
    private void backTrack(  List<Integer> path, boolean[] used, int[] nums) {
        //1.退出条件
        //所有数字都填完，表示结束
        if (nums.length== path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //2.当前逻辑
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {//如果没有被访问，则直接添加到path尾部
                path.add(nums[i]);//则直接添加到path尾部
                used[i] = true; //true表示当前节点被用过
                //3.向下递归 寻找下一个不重复的数  进行递归调用
                backTrack(path, used, nums);

                //4.善后处理
                //如果上一个数已经被用过了，那就退回到上一个节点
                used[i] = false;
                path.remove(path.size() - 1);//删除最后一个数
            }
        }
    }

    //递归调用
    private void backTrack2(List<Integer> path, int[] nums) {
        //1.退出条件
        if (nums.length== path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        //2.当前逻辑
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i]))//如果当前排列已有该数，则不往下遍历
                continue;
            path.add(nums[i]);//当前排列中没有该数，添加到末尾
            backTrack2(path,nums); //向下递归
            path.remove(path.size()-1);//向上回溯，表示当前排列中已添加该数，将其删除即可
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        List<List<Integer>> res = permute.permute(nums);
        System.out.println(res);
    }
}
