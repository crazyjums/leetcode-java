package simple;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public static int[][] find(int target) {
        //滑动窗口解法
        int i = 1;//滑动窗口的左边界
        int j = 1;//滑动窗口的右边界
        int sum = 0;//滑动窗口中的数字的和
        List<int[]> res = new ArrayList<>();
        while (i <= (target / 2)) {
            if (sum > target) { //左边界向右移动
                sum -= i ++;
            } else if (sum < target) { //右边界向右移动
                sum += j ++;
            } else { //刚好相等
                int[] tem = new int[j - i];
                for (int k = i; k < j; k ++) {
                    tem[k - i] = k;
                }
                res.add(tem);
                sum -= i ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        MyPrintFunction.print(find(9));
    }
}
