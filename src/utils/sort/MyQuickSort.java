package utils.sort;

import java.util.Arrays;

public class MyQuickSort {

    public void sort(int[] a) {
        quickSort(0, a.length - 1, a);
    }

    private void quickSort(int start, int end, int[] a) {
        if (start >= end)
            return;
        int pIndex = doubleRound(start, end, a);
        quickSort(start, pIndex - 1, a);
        quickSort(pIndex + 1, end, a);
    }

    private int doubleRound(int start, int end, int[] a) {
        int p = a[start];
        int l = start, r = end;
        while (l != r) {
            while (l < r && a[l] <= p)
                l++;
            while (l < r && a[r] > p)
                r--;
            if (l < r) {
                int t = a[l];
                a[l] = a[r];
                a[r] = t;
            }
        }
        a[start] = a[l];
        a[l] = p;
        return l;
    }


    public static void main(String[] args) {
        int[] a = {4, 7, 3, 5, 6, 2, 9, 8};
        System.out.println("原数组：" + Arrays.toString(a));

        MyQuickSort myQuickSort = new MyQuickSort();
        myQuickSort.sort(a);
        System.out.println("升序排序数组：" + Arrays.toString(a));
    }
}
