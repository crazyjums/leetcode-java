package utils.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private boolean up = true; //递增排序

    public BubbleSort(boolean up) {
        this.up = up;
    }

    public BubbleSort() {
    }

    public void setIncrease(boolean up){
        this.up=up;
    }

    public void bubbleSort(int[] arrayLike) {
        int n = arrayLike.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.up) {
                    if (arrayLike[j] > arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                    }
                } else {
                    if (arrayLike[j] < arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                    }
                }
            }
        }
    }

    /**
     * 优化1：
     * 当有些区间的数字已经排好序时，冒泡排序也会继续执行比较操作（内循环中）
     * 可以使用一个标签来记录当前序列是否已经排好序，可以避免对已经排好序的序列再次进行比较
     */
    public void bubbleSort2(int[] arrayLike) {
        int n = arrayLike.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true; //表示当前序列已经排好序
            for (int j = 0; j < n - i - 1; j++) {
                if (this.up) {
                    if (arrayLike[j] > arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                        isSorted = false;
                    }
                } else {
                    if (arrayLike[j] < arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                        isSorted = false;
                    }
                }
            }
            if (isSorted)
                break;
        }
    }

    /**
     * 有些序列可能前半部分已经是有序的，或者后半部分已经是有序的，
     * 只有一半的序列时处于无序的状态。那么当前就可以只针对那些处于无序的
     * 数据进行比较，已经有序的数据可以跳过，
     * 这里使用一个无序边界进行标记。
     *
     * @param arrayLike
     */
    public void bubbleSort3(int[] arrayLike) {
        int n = arrayLike.length;
        int sortBorder = n - 1; //数组中无序的边界下标  无序边界等于最后一次交换数据的下标j
        int lastIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (this.up) {
                    if (arrayLike[j] > arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                        isSorted = false;
                        lastIndex = j;
                    }
                } else {
                    if (arrayLike[j] < arrayLike[j + 1]) {
                        int t = arrayLike[j];
                        arrayLike[j] = arrayLike[j + 1];
                        arrayLike[j + 1] = t;
                        isSorted = false;
                        lastIndex = j;
                    }
                }
            }
            sortBorder = lastIndex;
            if (isSorted)
                break;
        }
    }

    public void bubbleSort(List<Integer> arrayLike) {
        int n = arrayLike.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (this.up) {
                    if (arrayLike.get(j) > arrayLike.get(j + 1)) {
                        int t = arrayLike.get(j);
                        arrayLike.set(j, arrayLike.get(j + 1));
                        arrayLike.set(j + 1, t);
                    }
                } else {
                    if (arrayLike.get(j) < arrayLike.get(j + 1)) {
                        int t = arrayLike.get(j);
                        arrayLike.set(j, arrayLike.get(j + 1));
                        arrayLike.set(j + 1, t);
                    }
                }

            }
        }
    }


    public void sort(int[] nums) {
        //记录已经排序的
        for (int i = 0; i < nums.length - 1; i++) {
            boolean isSorted = true;//表示当前已经排好序，之后的数据将不做比较与交换
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (this.up)
                    if (nums[j] > nums[j + 1]) {
                        int t = nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=t;
                        isSorted = false;
                    }
                if (!this.up)
                    if (nums[j] < nums[j + 1]) {
                        int t = nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=t;
                        isSorted = false;
                    }
            }
            if (isSorted)
                break;
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(true);
        int[] a = {7, 8, 6, 4, 9, 10, 12, 13};
        bubbleSort.setIncrease(false);

        bubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
