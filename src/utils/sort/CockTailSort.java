package utils.sort;

import java.util.Arrays;

public class CockTailSort {
    public void cockTailSort(int[] arrayLike) {
        int n = arrayLike.length;
        for (int i = 0; i < (int) (n / 2); i++) {
            boolean isSorted = true;
            for (int j = i; j < n - i - 1; j++) {
                if (arrayLike[j] > arrayLike[j + 1]) {
                    int t = arrayLike[j];
                    arrayLike[j] = arrayLike[j + 1];
                    arrayLike[j + 1] = t;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;

            isSorted = true;
            for (int j = n - i - 1; j > i; j--) {
                if (arrayLike[j] < arrayLike[j - 1]) {
                    int t = arrayLike[j];
                    arrayLike[j] = arrayLike[j - 1];
                    arrayLike[j - 1] = t;
                    isSorted = false;
                }
            }
            if (isSorted)
                break;
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 6, 5, 4, 3, 2, 1};
        CockTailSort cockTailSort = new CockTailSort();
        cockTailSort.cockTailSort(a);
        System.out.println(Arrays.toString(a));
    }
}
