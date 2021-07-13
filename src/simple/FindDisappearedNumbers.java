package simple;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDisappearedNumbers {
    List<Integer> res = new ArrayList<>();
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[nums[i]-1] != nums[i] ){
                int j = nums[i]-1;

                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i]!=i+1)res.add(i+1);
        }

        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!hashSet.contains(i+1))res.add(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        MyPrintFunction.print(new FindDisappearedNumbers().findDisappearedNumbers2(nums));
    }
}
