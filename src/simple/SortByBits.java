package simple;

import utils.MyPrintFunction;

import java.util.Arrays;

public class SortByBits {
    public int[] sortByBits(int[] arr) {
        int [] map = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            map[i] = Integer.bitCount(arr[i]) * 1000000 + arr[i];
        }
        Arrays.sort(map);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map[i] % 1000000;
        }
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pIndex = partition(arr, left, right);
        quickSort(arr, left, pIndex);
        quickSort(arr, pIndex + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pv = arr[left];
        int l = left, r = right;
        while (l != r) {
            while (l < r && getBinaryNum(arr[r]) > getBinaryNum(pv) && arr[r] >= pv) r --;
            while (l < r && getBinaryNum(arr[l]) < getBinaryNum(pv) && arr[l] <= pv) l ++;
//            while (l < r && arr[r] >= pv) {
//                if (getBinaryNum(arr[r]) > getBinaryNum(pv))
//                    r --;
//                else if (getBinaryNum(arr[r]) == getBinaryNum(pv) && arr[r] >= pv)
//                    r --;
//            }
//            while (l < r && arr[l] <= pv) {
//                if (getBinaryNum(arr[l]) < getBinaryNum(pv))
//                    l ++;
//                else if (getBinaryNum(arr[l]) == getBinaryNum(pv) && arr[l] <= pv)
//                    l ++;
//            }

            if (l < r) {
                arr[l] = arr[l] ^ arr[r];
                arr[r] = arr[l] ^ arr[r];
                arr[l] = arr[l] ^ arr[r];
            }
        }

        arr[left] = arr[l];
        arr[l] = pv;

        return l;
    }

    private int getBinaryNum(int num) {
        int count  = 0;
        while (num > 0) {
            num &= (num - 1);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        int [] a = {2,3,5,7,11,13,17,19};
        SortByBits sortByBits = new SortByBits();
        sortByBits.sortByBits(a);
        MyPrintFunction.print(a);
    }
}
