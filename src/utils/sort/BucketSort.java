package utils.sort;

import java.util.*;

public class BucketSort {
    private double[] array;
    private boolean up = true;

    public BucketSort(double[] array) {
        this.array = array;
    }

    public BucketSort(double[] array, boolean up) {
        this.array = array;
        this.up = up;
    }

    public void increaseSort(){
        int n = this.array.length;
        double min = this.array[0];
        double max = this.array[0];
        //找到数组中的最大值和最小值
        for (int i = 1; i < n; i++) {
            max = Math.max(max,this.array[i]);
            min = Math.min(min,this.array[i]);
        }
        //计算桶的大小
        int bucketNum = (int)((max-min)/n+1);
        List<List<Double>> bucket = new ArrayList<>(bucketNum); //创建一个桶

        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            //计算当前元素需要放在哪个桶中，得到那个桶的下标
            int bucIndex = (int)((this.array[i]-min)/n);
            bucket.get(bucIndex).add(this.array[i]);
        }

        //对每个桶中的所有元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(bucket.get(i));
        }


        //将桶中的元素打印输出
        int c = 0;
        if (up){
            for (int i = 0; i < bucketNum; i++) {
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    this.array[c++] = bucket.get(i).get(j);
                }
            }
        }else{
            for (int i = bucketNum-1; i >-1; i--) {
                for (int j = bucket.get(i).size()-1; j >-1 ; j--) {
                    this.array[c++] = bucket.get(i).get(j);
                }
            }
        }
    }

    public void increaseSort1(){
        int n = this.array.length;
        double min = this.array[0];
        double max = this.array[0];
        //找到数组中的最大值和最小值
        for (int i = 1; i < n; i++) {
            max = Math.max(max,this.array[i]);
            min = Math.min(min,this.array[i]);
        }
        //计算桶的大小
        List<List<Double>> bucket = new ArrayList<>(n); //创建一个桶

        for (int i = 0; i < n; i++) {
            bucket.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            //计算当前元素需要放在哪个桶中，得到那个桶的下标
            int bucIndex = (int)(((this.array[i] - min ) * (n - 1)) / (max-min));
            bucket.get(bucIndex).add(this.array[i]);
        }

        //对每个桶中的所有元素进行排序
        for (int i = 0; i < n; i++) {
            Collections.sort(bucket.get(i));
        }

        //将桶中的元素打印输出
        int c = 0;
        if (up){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < bucket.get(i).size(); j++) {
                    this.array[c++] = bucket.get(i).get(j);
                }
            }
        }else{
            for (int i = n-1; i >-1; i--) {
                for (int j = bucket.get(i).size()-1; j >-1 ; j--) {
                    this.array[c++] = bucket.get(i).get(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        double[]a = {12,0.052,4.52,2.01,9.36,1.63};
        System.out.println(Arrays.toString(a));
        BucketSort bucketSort = new BucketSort(a,false);

        bucketSort.increaseSort();
        System.out.println(Arrays.toString(a));

        bucketSort.increaseSort1();
        System.out.println(Arrays.toString(a));
    }
}
