package middle;

import utils.MyPrintFunction;

public class FindKthWithBF {
    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n - 1);
        return a[a.length - K];
    }

    private void quickSort(int[] a, int start, int end) {
        //= partition(a,start,end);//从大到小排序  每次执行完partition之后，能确定数组中第pIndex大的数，

        if (start >= end)
            return;
        MyPrintFunction.print(a);
        int pIndex = partition(a, start, end);
        quickSort(a, start, pIndex - 1);
        quickSort(a, pIndex + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int p = a[start];
        int mark = start;
        for (int i = start; i <= end; i++) {
            if (a[i] < p) {
                mark++;
                int t = a[i];
                a[i] = a[mark];
                a[mark] = t;
            }
        }
        a[start] = a[mark];
        a[mark] = p;
        return mark;
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 6, 4, 5};
        int k = 3;
        FindKthWithBF findKthWithBF = new FindKthWithBF();
        int res = findKthWithBF.findKth(a, a.length, k);
        System.out.println(res);
        MyPrintFunction.print(a);
    }
}
