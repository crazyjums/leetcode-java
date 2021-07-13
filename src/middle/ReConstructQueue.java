package middle;

import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReConstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        /**
         * 将二维数组按行降序、列升序排序
         */
        Arrays.sort(people,((o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]));
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] == o2[0] ?o1[1] - o2[1]  :o2[0]-o1[0] ;
//            }
//        });
        /**
         * 思路：
         * 个子矮的人相对高的人来说，个子高的人是看不见个子矮的人的，所以，将数组按照行降序列升序排序后，
         * 然后根据他前面还有k个与他身高相等或高于他的人，进行插入插入排序，每次插入按照k为索引进行插入
         */
        List<int[]> res = new ArrayList<>();
        for (int[]i:people) {
            res.add(i[1],i);
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][]nums={
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        MyPrintFunction.print(new ReConstructQueue().reconstructQueue(nums));
    }
}
