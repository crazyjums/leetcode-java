package simple;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {
    /**
     * 时间复杂度是：O(n)
     * 空间复杂度是：O(n)
     * @param array
     * @return
     */
    public int moreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else
                map.put(array[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 2))
                return entry.getKey();
        }
        return 0;
    }

    /**
     * 思路：(假设有一个数的数量超过数组长度的一半)
     * 1.每次循环，将众数与其他的数低效
     * @param array
     * @return
     */
    public int solution2(int[]array){
        if (array==null||array.length==0)return 0;
        int pre=array[0];//上次访问过的数字
        int count=1;//pre出现的次数
        for (int i = 1; i < array.length; i++) {
            if (array[i]==pre){
                count++;
            }else{
                count--;
                if (count==0){
                    pre=array[i];
                    count=1;
                }
            }
        }
        int count2=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==pre)
                count2++;
        }
        return count2>(array.length/2)?pre:0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MoreThanHalfNum().solution2(nums));
    }
}
