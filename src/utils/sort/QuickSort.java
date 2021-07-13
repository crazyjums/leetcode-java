package utils.sort;

import java.util.Arrays;

public class QuickSort {
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    //升序排序
    public void increaseSortByDouble() {
        doubleRound(0, this.array.length - 1);
    }

    //升序排序
    public void increaseSortBySingle() {
        singleRound(0, this.array.length - 1);
    }

    //降序排序
    public void decreaseSortBySingle() {
        singleRound2(0, this.array.length - 1);
    }

    //降序排序
    public void decreaseSortByDouble() {
        doubleRound2(0, this.array.length - 1);
    }

    //升序排序
    private void doubleRound(int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = swepDoubleRound(start, end);
        doubleRound(start, pivotIndex - 1);
        doubleRound(pivotIndex + 1, end);
    }

    //升序排序
    private void singleRound(int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = swepSingleRound(start, end);
        singleRound(start, pivotIndex - 1);
        singleRound(pivotIndex + 1, end);
    }

    //升序排序
    private int swepSingleRound(int start, int end) {
        int p = this.array[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            /**
             * 如果当前元素a[i]小于基准元素的值，那么mark指针右移一位，此时将mark指针上的值和a[i]交换
             */
//            System.out.println("start="+start+",end="+end+",pivot="+p+",i="+i+","+Arrays.toString(this.array)+",a["+i+"]="+this.array[i]);
            if (this.array[i] < p) {
                mark++;
                int t = this.array[mark];
                this.array[mark] = this.array[i];
                this.array[i] = t;
            }
        }
        //最后将mark指针上的元素和基准元素交换
        this.array[start] = this.array[mark];
        this.array[mark] = p;
        return mark;
    }

    //降序排序
    private void singleRound2(int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = swepSingleRound2(start, end);
        singleRound2(start, pivotIndex - 1);
        singleRound2(pivotIndex + 1, end);
    }

    //降序排序
    private int swepSingleRound2(int start, int end) {
        int p = this.array[start];
        int mark = start;
        for (int i = start + 1; i <= end; i++) {
            /**
             * 如果当前元素a[i]大于基准元素的值，那么mark指针右移一位，此时将mark指针上的值和a[i]交换
             */
//            System.out.println("start="+start+",end="+end+",pivot="+p+",i="+i+","+Arrays.toString(this.array)+",a["+i+"]="+this.array[i]);
            if (this.array[i] > p) {
                mark++;
                int t = this.array[mark];
                this.array[mark] = this.array[i];
                this.array[i] = t;
            }
        }
        //最后将mark指针上的元素和基准元素交换
        this.array[start] = this.array[mark];
        this.array[mark] = p;
        return mark;
    }


    //升序排序
    private int swepDoubleRound(int start, int end) {
        int l = start, r = end;  //左右指针，分别指向头和尾
        int p = this.array[start]; //基准值，以第一个元素为基准值
        while (l != r) {
            //当左指针小于右指针，且右指针指向的元素大于基准元素时，右指针左移,表示当前元素需要放在数组后半部分
            while (l < r && this.array[r] > p)
                r--;
            //当左指针小于右指针，且左指针指向的元素小于等于基准元素时，左指针右移，表示当前元素需要放在数组前半部分
            while (l < r && this.array[l] <= p)
                l++;

            //当左右指针都不在移动时，交换左右指针位置上的值
            if (l < r) {
                int t = this.array[l];
                this.array[l] = this.array[r];
                this.array[r] = t;
            }
        }

        //当左右指针重合时，次数当前比较结束，并将基准元素和中间元素交换，使用左和右指针都可以
        this.array[start] = this.array[l];
        this.array[l] = p;

        return l;
    }

    //降序排序
    private void doubleRound2(int start, int end) {
        if (start >= end)
            return;
        int pivotIndex = swepDoubleRound2(start, end);
        doubleRound2(start, pivotIndex - 1);
        doubleRound2(pivotIndex + 1, end);
    }

    //降序排序
    private int swepDoubleRound2(int start, int end) {
        int l = start, r = end;  //左右指针，分别指向头和尾
        int p = this.array[start]; //基准值，以第一个元素为基准值
        while (l != r) {
            //当左指针小于右指针，且右指针指向的元素大于基准元素时，右指针左移,表示当前元素需要放在数组后半部分
            while (l < r && this.array[r] < p)
                r--;
            //当左指针小于右指针，且左指针指向的元素小于等于基准元素时，左指针右移，表示当前元素需要放在数组前半部分
            while (l < r && this.array[l] >= p)
                l++;

            //当左右指针都不在移动时，交换左右指针位置上的值
            if (l < r) {
                int t = this.array[l];
                this.array[l] = this.array[r];
                this.array[r] = t;
            }
        }
        //当左右指针重合时，次数当前比较结束，并将基准元素和中间元素交换，使用左和右指针都可以
        this.array[start] = this.array[l];
        this.array[l] = p;

        return l;
    }


    public void stackRound(int[] array) {

    }


    public void sort(int[] nums) {
        doubleRound4(0, nums.length - 1, nums);
    }

    private void doubleRound4(int start, int end, int[] nums) {
        if (start >= end) {
            return;
        }
        int pIndex = getPIndex(start, end, nums);
        doubleRound4(start, pIndex - 1, nums);
        doubleRound4(pIndex + 1, end, nums);


    }

    private int getPIndex(int start, int end, int[] nums) {
        int p = nums[start];
        int l = start, r = end;
        while (l != r) {
            while (l < r && nums[l] <= p)
                l++;
            while (l < r && nums[r] > p)
                r--;
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        /**
         * 交换基准元素和中间的元素值
         */
        nums[start] = nums[l];
        nums[l] = p;
        return l;
    }


    public static void main(String[] args) {
        int[] a = {4, 7, 3, 5, 6, 2, 9, 8};
        System.out.println("原数组：" + Arrays.toString(a));
        QuickSort quickSort = new QuickSort(a);

        quickSort.sort(a);
        System.out.println("双指针-升序排序：" + Arrays.toString(a));

        quickSort.decreaseSortByDouble();
        System.out.println("双指针-降序排序：" + Arrays.toString(a));
//
        quickSort.increaseSortBySingle();
        System.out.println("单指针-升序排序：" + Arrays.toString(a));
//
//        quickSort.decreaseSortBySingle();
//        System.out.println("单指针-降序排序：" + Arrays.toString(a));

    }


}
