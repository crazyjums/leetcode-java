package middle;

import utils.MyPrintFunction;

public class FindKthWithQuickSort {

    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    private int quickSort(int[] a, int start, int end, int K) {
        MyPrintFunction.print(a);
        int l = start, r = end;
        int p = a[start];
        while (l < r) { //降序排序
            while (l < r && a[r] < p) r--;
            a[l] = a[r];
            while (l < r && a[l] >= p) l++;
            a[r] = a[l];
        }
        a[l] = p;

        if (l == K - 1)
            return a[l];
        else if (l > K - 1) { //表示该数在数组左边
            return quickSort(a, start, l - 1, K);
        } else { //表示该数在数组右边
            return quickSort(a, l + 1, end, K);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 6, 4, 5};
        int k = 3;
        FindKthWithQuickSort findKthWithQuickSort = new FindKthWithQuickSort();
        int res = findKthWithQuickSort.findKth(a, a.length, k);
        System.out.println(res);
    }
}
