package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSumNumbers {
    public static void main(String[] args) {
        FindSumNumbers findSumNumbers = new FindSumNumbers();
        int [] nums = {1,12,3,5,7,10,6};
        int target = 13;
        List<List<Integer>> res = findSumNumbers.twoSum2(nums,target);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                System.out.print(res.get(i).get(j)+"  ");
            }
            System.out.println();
        }
    }
    // 采用哈希表
    public List<List<Integer>> twoSum(int [] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < n; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)){
                List<Integer> tem = new ArrayList<>();
                tem.add(i);
                tem.add(map.get(t));
                res.add(tem);
                map.remove(nums[i]);
            }
        }
        return res;
    }

    // 采用哈希表 简化版
    public List<List<Integer>> twoSum2(int [] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i],i);
            int t = target - nums[i];
            if (map.containsKey(t)){
                List<Integer> tem = new ArrayList<>();
                tem.add(i);
                tem.add(map.get(t));
                res.add(tem);
                map.remove(nums[i]);
            }
        }
        return res;
    }
}
