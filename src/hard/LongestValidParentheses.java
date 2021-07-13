package hard;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        /**
         * 方法1：使用栈
         * 时间：O(N)
         * 空间：O(N)
         */
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        /**
         * 栈底元素为最后一个没有被匹配的右括号（‘)’）的下标，
         */
        stack.push(-1);//-1插入括号之前有一个没有被匹配的右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }

    public int longestValidParentheses2(String s) {
        /**
         * 思路：
         *      使用三个变量，分别：
         *          - 保存最长的有效括号的个数（是一个偶数）
         *          - 左括号的个数
         *          - 右括号的个数
         *       从左往右遍历时，右括号的个数不能比左括号多，如果比左括号多，那么将左右括号的值赋值为0，表示被多出来的这个右括号阻断了
         *       从右往左遍历时，左括号的个数不能比右括号多，如果比右括号多，则将左右括号的值赋值为0，表示被多出来的这个左括号阻断了
         *
         */
        int maxlen=0,left=0,right=0,n=s.length();
        //从左往右遍历
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='(')
                left++;
            else if (s.charAt(i)==')')
                right++;
            if (right==left)
                maxlen = Math.max(maxlen,right * 2);
            else if (right>left)
                left = right = 0;
        }
        left = right = 0;//从右往左遍历需要清零
        //从右往左遍历
        for (int i = n-1; i >=0 ; i--) {
            if (s.charAt(i)=='(')
                left++;
            else if (s.charAt(i)==')')
                right++;
            if (left==right)
                maxlen = Math.max(maxlen,right * 2);
            else if (left>right)
            {
                left=right=0;
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String s = ")()";
        int res = new LongestValidParentheses().longestValidParentheses2(s);
        System.out.println(res);
    }
}
