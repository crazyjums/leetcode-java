package middle;

import utils.MyPrintFunction;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    /*
    求K个平方和最小的点的坐标组合
    */
    public int[][] kClosest(int[][] points, int K) {
        if (K >= points.length) return points;
        int[][] res = new int[K][2];
        int[][] tem = new int[points.length][2];//第一列存平方和，第二列存下标

        for (int i = 0; i < points.length; i++) {
            tem[i][0] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            tem[i][1] = i;
        }

        // Arrays.sort(tem, new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b) {
        //         return a[0] - b[0];
        //     }
        // });
        int l = 0, r = tem.length - 1;
        int mid = partition(tem, l, r);
        while (mid != K) {
            if (mid > K)
                r = mid -1;
            else if (mid < K)
                l = mid + 1;
            mid = partition(tem, l, r);
        }
        MyPrintFunction.print(tem);


        for (int i = 0; i < K; i++) {
            res[i][0] = points[tem[i][1]][0];
            res[i][1] = points[tem[i][1]][1];
        }

        return res;
    }

    private int partition(int[][] nums, int left, int right) {
        int p1 = left, p2 = right, pv = nums[left][0], pi = nums[left][1];
        while (p1 != p2) {
            while (p1 < p2 && nums[p2][0] > pv) p2 --;
            while (p1 < p2 && nums[p1][0] < pv) p1 ++;
            if (p1 < p2) {
                nums[p1][0] = nums[p1][0] ^ nums[p2][0];
                nums[p2][0] = nums[p1][0] ^ nums[p2][0];
                nums[p1][0] = nums[p1][0] ^ nums[p2][0];

                nums[p1][1] = nums[p1][1] ^ nums[p2][1];
                nums[p2][1] = nums[p1][1] ^ nums[p2][1];
                nums[p1][1] = nums[p1][1] ^ nums[p2][1];
            }
        }
        nums[left][0] = nums[p1][0];
        nums[left][1] = nums[p1][1];
        nums[p1][0] = pv;
        nums[p1][1] = pi;
        return p1;
    }



    public int[] knum(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int mid = part(nums, l , r);
        while (mid != k) {
            if (mid > k)
                r = mid - 1;
            else if (mid < k)
                l = mid + 1;
            mid = part(nums, l , r);
        }
        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    private int part(int[] nums, int start, int end) {
        int pv = nums[start], l = start, r = end;
        while (l != r) {
            while (l < r && nums[r] >= pv) r --;
            while (l < r && nums[l] <= pv) l ++;
            if (l < r) {
                nums[l] = nums[r] ^ nums[l];
                nums[r] = nums[r] ^ nums[l];
                nums[l] = nums[r] ^ nums[l];
            }
        }
        nums[start] = nums[l];
        nums[l] = pv;
        return l;
    }

    public int[][] kClosest2(int[][] points, int K) {
        if (K >= points.length) return points;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int[][] res = new int[K][2];

        for (int i = 0; i < points.length; i ++) {
            int t = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (queue.isEmpty() || i < K) {
                queue.add(new int[]{t, i});
            } else {
                if (t < queue.peek()[0]) {
                    queue.poll();
                    queue.add(new int[]{t, i});
                }
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            res[i++] = points[queue.poll()[1]];
        }
        return res;
    }
    public static void main(String[] args) {
        int [][] points = {{3,3},{-2,2},{2,-2}};
        int[][] res = new KClosest().kClosest2(points, 2);
        MyPrintFunction.print(res);
        int [][] a = {{1,2},{3,4}};

        int[] aa = {5,3,8,1,0,4};
        MyPrintFunction.print(new KClosest().knum(aa,3));

    }
}
