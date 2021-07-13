package utils.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountSort {
    private int[] array;

    public CountSort(int[] array) {
        this.array = array;
    }

    public void increaseSortOrigin(){
        int n = this.array.length;
        int max = this.array[0];
        for (int i = 1; i < n; i++) {
            if (this.array[i]>max)
                max=this.array[i];
        }
        int [] countArray = new int[max+1];
        for (int i = 0; i < n; i++) {
            countArray[this.array[i]] ++;
        }
        System.out.println(Arrays.toString(countArray));
        int c=0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                this.array[c] = i;
                c++;
            }
        }
    }

    public void increaseSort(){
        int n = this.array.length;
        int max = this.array[0];
        int min = this.array[0];
        for (int i = 1; i < n; i++) {
            if (this.array[i] > max)
                max = this.array[i];
            if (this.array[i] < min)
                min= this.array[i];
        }
        int [] countArray = new int[max-min+1];
        for (int i = 0; i < n; i++) {
            countArray[this.array[i]-min] ++;
        }
        System.out.println(Arrays.toString(countArray));
        int c = 0;
        for (int i = 0; i < max-min+1; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                this.array[c] = i+min;
                c++;
            }
        }
    }

    public void decreaseSort(){
        int n = this.array.length;
        int max = this.array[0];
        int min = this.array[0];
        for (int i = 1; i < n; i++) {
            if (this.array[i] > max)
                max = this.array[i];
            if (this.array[i] < min)
                min = this.array[i];
        }
        int []countArray = new int[max-min+1];
        for (int i = 0; i < n; i++) {
            countArray[this.array[i]-min ] ++;
        }
        int c = 0;
        for (int i = max-min; i >-1; i--) {
            for (int j = 0; j < countArray[i]; j++) {
                this.array[c] = i+min;
                c++;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {92,94,93,92,92,92,95,95,96,92,99,98,98,99};
        System.out.println("原数组："+ Arrays.toString(a));
        CountSort countSort = new CountSort(a);

//        countSort.decreaseSort();
//        System.out.println("降序排序："+ Arrays.toString(a));

        countSort.increaseSort();
        System.out.println("升序排序："+ Arrays.toString(a));
        List<Integer> b = new ArrayList<>();

    }

}
