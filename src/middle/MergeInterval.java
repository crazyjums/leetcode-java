package middle;

import utils.MyPrintFunction;

import java.util.*;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<2)
            return intervals;
        //对第0列进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        List<int []> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int curInterval[] = intervals[i];

            int peek[] = res.get(res.size()-1); //结果集中的最大值

            if (intervals[i][0] > peek[1]){//如果第二个区间的左边大于了前一个区间的右边，则说明二者没有交集
                res.add(curInterval);
            }else{//否则说明二者有交集，则应该将第一个区间的右边界更新到最大的那个  因为所有的区间都是按照左边界升序排序，所以不需要
                //担心之后的区间会与之前的有交集
                peek[1] = Math.max(peek[1],curInterval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        int[][]intervals = {
                {2,6},{1,3},{8,16},{15,18}
        };
        MergeInterval mergeInterval =new MergeInterval();
        int[][]res=mergeInterval.merge(intervals);
        MyPrintFunction.print(res);
    }
}
