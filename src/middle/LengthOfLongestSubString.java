package middle;

import org.junit.Test;

import java.util.*;

public class LengthOfLongestSubString {
    public int sulution1(String str) {
        if (str.length() == 0)
            return 0;
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(left, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int sulution2(String s) {
        int n = s.length();
        int max = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int k = 0; k < n; k++) {
            while (queue.contains(s.charAt(k)))
                queue.poll();
            queue.add(s.charAt(k));
            max = Math.max(max, queue.size());
        }

        return max;
    }

    public int sulution3(String s) {
        int n = s.length();
        int max = 0;
//        Queue<Character> queue = new LinkedList<>();
//        for (int k = 0; k < n; k++) {
//            while (queue.contains(s.charAt(k)))
//                queue.poll();
//            queue.add(s.charAt(k));
//            max = Math.max(max,queue.size());
//        }



//        HashSet<Character> set = new HashSet<>();
//        int left = 0, right = 0;
//        for (int i = 0; i < n; i++) {
//            while (right < n && !set.contains(s.charAt(right))) {
//                set.add(s.charAt(right++));
//            }
//            max = Math.max(max, right - left);
//            set.remove(s.charAt(left++));
//        }


        int[]m = new int[128];
        Arrays.fill(m,-1);
        int left = -1;
        for (int i = 0; i < n; i++) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            max = Math.max(max,i-left);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LengthOfLongestSubString lengthOfLongestSubString = new LengthOfLongestSubString();
        int res = lengthOfLongestSubString.sulution3(s);
        System.out.println(res);

    }
}
