package utils.sort;


import utils.MyPrintFunction;

import java.util.Arrays;

public class HeapSort {
    private int[] a;

    public HeapSort(int[] a) {
        this.a = a;
    }

    public void increaseSort() {
        int n = this.a.length;
        for (int i = (int) (n - 2) / 2; i >= 0; i--) {
            downAdjust(i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            int t = this.a[i];
            this.a[i] = this.a[0];
            this.a[0] = t;
            downAdjust(0, i);
            MyPrintFunction.print(a);
        }
    }

    private void downAdjust(int pIndex, int n) {
        int childIndex = 2 * pIndex + 1;
        int tem = this.a[pIndex];
        while (childIndex < n) {
            //当有右子树且右子树的值大于左子树的值，则定位到右子树，让大的数参与比较
            if (childIndex + 1 < n && this.a[childIndex + 1] > this.a[childIndex])
                childIndex++;
            if (tem > this.a[childIndex])
                break;
            this.a[pIndex] = this.a[childIndex];
            pIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        this.a[pIndex] = tem;
    }

    private void upAdjust(int childIndex, int n) {
        int tem = this.a[childIndex];
        int parentIndex = (childIndex - 1) >> 1;
        while (childIndex > 0 && this.a[parentIndex] < this.a[childIndex]) { //最大堆
            this.a[childIndex] = this.a[parentIndex];
            this.a[parentIndex] = tem;
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) >> 1;
        }
        this.a[childIndex] = tem;
    }

    private void downAdjust2(int pIndex, int n) {
        int childIndex = 2 * pIndex + 1;
        int tem = this.a[pIndex];
        while (childIndex < n) {
            if (childIndex + 1 < n && this.a[childIndex + 1] < this.a[childIndex])
                childIndex++;
            if (tem < this.a[childIndex])
                break;
            this.a[pIndex] = this.a[childIndex];
            pIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        this.a[pIndex] = tem;
    }

    public void decreaseSort() {
        int n = this.a.length;
        for (int i = (int) (n - 2) / 2; i > -1; i--) {
            downAdjust2(i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            a[i] = a[0] ^ a[i];
            a[0] = a[0] ^ a[i];
            a[i] = a[0] ^ a[i];
            downAdjust2(0, i);
            MyPrintFunction.print(a);
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 13, 8, 9, 10, 18, 16, 1, -9};
        System.out.println("原数组：" + Arrays.toString(a));
        HeapSort heapSort = new HeapSort(a);
        heapSort.decreaseSort();
        System.out.println("降序排序：" + Arrays.toString(a));
//
        heapSort.increaseSort();
        System.out.println("升序排序："+Arrays.toString(a));
    }
}
