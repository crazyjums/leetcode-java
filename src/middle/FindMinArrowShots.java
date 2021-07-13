package middle;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1])
                    return 1;
                else if (o1[1] < o2[1])
                    return -1;
                else
                    return 0;
//                return o1[1] - o2[1]; //这种写法可能导致整型越界
            }
        });
        /*
        思路，让所有区间按照边界的右边界进行从小到大排序
        选择一个参照区间，让下一个区间与该参照区间的右边界进行比较，
            - 如果下一个区间的左边界大于参照区间的右边界，则他们没有交集，只能换一只弓箭
            - 如果下一个区间的左边界小于等于参照区间的右边界，则说明他们可以使用一只箭射穿，更新参照区间的右边界
        */
        int res = 1;
        int flag = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // int[] t = points[i];
            if (points[i][0] > flag) {
                res++;
                flag = points[i][1];
            }
        }
        // System.out.println(flag);
        return res;
    }

    public static void main(String[] args) {
//        int[][] p = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        int[][] p = {{10,-16},{4,8},{1,6},{3,12}};
        System.out.println(-2147483645 - 2147483647);
        int res = new FindMinArrowShots().findMinArrowShots(p);
        MyPrintFunction.print(p);
        System.out.println(res);
    }
}
