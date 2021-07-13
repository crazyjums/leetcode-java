package middle;

import java.util.HashMap;
import java.util.Map;

public class IsPossible {
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> numcount = new HashMap<>(); //存储数字num出现的次数
        Map<Integer, Integer> tail = new HashMap<>(); //存储以数字num结尾的子序列的个数
        for (int num : nums) {
            numcount.put(num, numcount.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (numcount.get(num) == 0) continue;
            else if (numcount.get(num) > 0 && tail.containsKey(num - 1) && tail.get(num - 1) > 0) {
                numcount.put(num, numcount.get(num) - 1);
                tail.put(num - 1, tail.getOrDefault(num - 1, 0) - 1);
                tail.put(num, tail.getOrDefault(num, 0) + 1);
            } else if (numcount.containsKey(num) && numcount.get(num) > 0 && numcount.containsKey(num + 1) && numcount.get(num + 1) > 0 && numcount.containsKey(num + 2) && numcount.get(num + 2) > 0) {
                numcount.put(num, numcount.get(num) - 1);
                numcount.put(num + 1, numcount.get(num + 1) - 1);
                numcount.put(num + 2, numcount.get(num + 2) - 1);
                tail.put(num + 2, tail.getOrDefault(num + 2, 0) + 1);
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,5};
        System.out.println(isPossible(nums));
    }
}
