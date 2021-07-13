package simple;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeGood {
    public String makeGood(String s) {
        if (s == null || s.length() == 0) return s;

        // StringBuffer res = new StringBuffer();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (res.length() > 0
        //         && res.charAt(res.length() - 1) != ch
        //         && Character.toLowerCase(ch) == Character.toLowerCase(res.charAt(res.length() - 1))) {
        //         res.deleteCharAt(res.length() - 1);
        //     } else {
        //         res.append(ch);
        //     }
        // }
        // return res.toString();


        //使用栈
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                if (Character.toLowerCase(stack.peekLast()) == Character.toLowerCase(ch) && stack.peekLast() != ch) {
                    stack.pollLast();
                    continue;
                }
            }
            stack.addLast(ch);
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty())
            res.append(stack.pollLast());
        return res.reverse().toString();
    }

    //查找当前元素是否在后续数组存在
    private static boolean inBehind(int index, String s, char c) {
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
        System.out.println(new MakeGood().makeGood("leEeetcode"));

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        q.addLast(2);
        q.addLast(3);
        for (Integer n : q) {
            System.out.println(n);
        }

        while (!q.isEmpty())
            System.out.println(q.pollLast());

        String ss = "abcdsbca";
        System.out.println(inBehind(4,ss,'a'));
        System.out.println(ss.indexOf('a',4));
    }
}
