package hard;

import utils.MyPrintFunction;

import java.util.*;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //合并区间
        List<int[]> res = new ArrayList<>();
        if (intervals==null || intervals.length == 0) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }

        int left = newInterval[0];
        int right = newInterval[1];

        boolean placed = false;
        for (int[] each:intervals) {
            if(each[0] > right) {//当前区间在待插入区间的右边，且没有交集
                if(!placed){
                    res.add(new int[]{left,right});
                    placed = true;
                }
                res.add(each);
            } else if (each[1] < left) {//当前区间在待插入区间的左边且没有交集
                res.add(each);
            }else { //有交集
                //计算并集的左右区间
                left = Math.min(left,each[0]);
                right = Math.max(right,each[1]);
            }
        }
        //如果待插入区间在所有区间的右边，则最后插入
        if (!placed){
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();
        int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][]a = {};
        int []interval = {4,8};
        int [][]res=insertIntervals.insert(intervals,interval);
        MyPrintFunction.print(res);
    }
}
