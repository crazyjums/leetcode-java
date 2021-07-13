package middle;

import java.util.Arrays;

public class LLS {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max = 0;
        // Queue<Character> queue = new LinkedList<>();
        // for(char c : s.toCharArray()){
        //     while(queue.contains(c))
        //         queue.poll();
        //     queue.add(c);
        //     max = max > queue.size() ? max : queue.size();
        // }


//         HashSet<Character> set = new HashSet<>();
//         int left = 0, right = 0;
//         for(int i=0;i<n;i++){
//             while(right < n && !set.contains(s.charAt(right)))
//                 set.add(s.charAt(right++));
//             max = Math.max(right-left,max);

//             set.remove(s.charAt(left++));
//         }


        /**
         思路：使用两个指针，进行遍历，
         - 一个右指针每次指向字符串中的最新字符，
         - 并定义一个数组用来存放所有字符在字符串中出现的下标，因为一共有128个字符，所以可以定义一个长度为128的数组，
         数组的初始值是-1，每次遍历字符串中的字符，并记录下当前字符的下标
         - 定义一个左指针，用来记录right指针之前的重复字符出现的位置，默认是-1，表示没有，由于left和right对应的
         是一个左开右闭区间，所以长度可以直接使用left-right进行求值

         **/
         int[] m = new int[128];//一共有128个ASCII字符
         Arrays.fill(m,-1);
         int left = -1;
         for(int i=0;i<n;i++){
             left = Math.max(left, m[s.charAt(i)]);
             m[s.charAt(i)] = i;//记录下重复字符的下标
             max = Math.max(max,i-left);
         }

         return max;
    }

    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(new LLS().lengthOfLongestSubstring(s));
    }
}
