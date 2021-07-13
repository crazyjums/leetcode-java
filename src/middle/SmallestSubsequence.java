package middle;

import utils.MyPrintFunction;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SmallestSubsequence {
    public String smallestSubsequence(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (stack.contains(ch))
                continue;
            while (!stack.isEmpty() && ch < stack.peekLast() && inBehind(i, s, stack.peekLast())) { //inBehind(i, s, stack.peekLast())
                stack.pollLast();
            }
            stack.addLast(ch);
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty())
            res.append(stack.pollLast());
        return res.reverse().toString();
    }

    //查找当前元素是否在后续数组存在
    private boolean inBehind(int index, String s, char c) {
        boolean res = false;
        for (int i = index; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res = true;
                break;
            }
            else
                continue;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestSubsequence().smallestSubsequence("bcabc"));
        int [] a= {3,4,5,6,7};
        int[] b = Arrays.copyOfRange(a,1,a.length);
        MyPrintFunction.print(b);
    }
}
