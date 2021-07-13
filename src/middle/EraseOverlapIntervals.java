package middle;

import utils.MyPrintFunction;

import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        /**
         * 思路：
         *      题目要求提出区间的最小数量，使其没有重叠，那么可以反过来理解，
         *      也就是说要保留尽可能多的区间，使其不重叠，那么此题目可以看成是
         *      经典的LIS（最长升序子序列）问题进行求解，使用动态规划的思想
         *     先对区间进行排序
         */
        if (intervals.length==0)return 0;
        Arrays.sort(intervals,((o1, o2) -> o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1]));
        int[]dp=new int[intervals.length];
        dp[0]=1;
        int max=1;
        for (int i = 0; i < intervals.length; i++) {
            dp[i]=1;
            for (int j = 0; j <= i; j++) {
                if (intervals[i][0]>=intervals[j][1]){//第i个区间的首部大于第j个区间的尾部，i在j的后面
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }

            }
        }
        return intervals.length-max;
    }
    public int eraseOverlapIntervals2(int[][] intervals) {
        /**
         * 思路：
         *      在上一个解题思路的基础上，可以进行优化，还是先对区间进行排序，
         *      使用贪心算法，每次选取的区间使其尾部值尽可能的小，这样，在下次选择
         *      区间时就可以尽可能多放置几个
         */
        if (intervals.length==0)return 0;
        int res=1;//存放LIS的值
        int pre=0;//表示上一个被选取的区间。初始值是0，即第一个区间
        Arrays.sort(intervals,((o1, o2) -> o1[1]!=o2[1]?o1[1]-o2[1]:o1[0]-o2[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0]>=intervals[pre][1]){//当第i个区间的首部大于等于上一个区间的尾部时，表示该区间符合要求
                pre=i;
                res++;
            }
        }
        return intervals.length-res;
    }

    public static void main(String[] args) {
        int[][]intervals={ {1,2}, {2,3}, {3,4}, {1,3} };
        int res = new EraseOverlapIntervals().eraseOverlapIntervals2(intervals);
        System.out.println(res);
    }
}
