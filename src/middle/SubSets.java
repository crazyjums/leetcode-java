package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = 1<<nums.length;//nums.length的2次方
        for (int i = 0; i < n; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {//从数组中选择数字作为子集
                /**
                 * 每次让i移动j位，比如：010，
                 *                  第一次，j=0,此时i移动0位，-> i=010  010&1==0 => 不添加第j位
                 *                  第二次，j=1,此时i移动1位，-> i=001  001&1==1 => 添加第j位
                 *                  第三次，j=2，此时i移动2位,-> i=000  000&1==0 => 不添加
                 */
                if (((i>>j)&1)==1) //每次让i移动j位，
                    sub.add(nums[j]);

            }
            res.add(sub);
        }
//        int n = nums.length;
//        for (int i = (int)Math.pow(2,n); i < (int)Math.pow(2,n+1); i++) {
//            List<Integer> sub = new ArrayList<>();
//            String binary = Integer.toBinaryString(i).substring(1);
//            System.out.println(binary);
//            for (int j = 0; j < n; j++) {
//                if (binary.charAt(j)=='1')sub.add(nums[j]);
//            }
//            res.add(sub);
//        }

        return res;
    }

    public static void main(String[] args) {
        int[]nums={1,2,3};
        SubSets subSets = new SubSets();
        MyPrintFunction.print(subSets.subsets(nums));
        System.out.println(Math.pow(2,3));
    }

}
