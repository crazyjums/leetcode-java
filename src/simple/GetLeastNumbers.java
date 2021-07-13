package simple;

import utils.MyPrintFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        int res[] = new int[k];
        if (k>arr.length||k<=0)return res;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (queue.size()<k)
                queue.add(arr[i]);
            else{
                if (queue.peek() > arr[i]){
                    queue.remove(queue.peek());
                    queue.add(arr[i]);
                }
            }
        }
//        int []res = new int[k];
//        int i=0;
//        while (!queue.isEmpty()){
//            res[i++]=queue.poll();
//        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[]nums={0,0,0,2,0,5};
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(nums,0)));
    }
}
