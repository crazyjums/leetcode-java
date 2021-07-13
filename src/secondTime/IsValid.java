package secondTime;

import java.util.Stack;

public class IsValid {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid(String s) {
        // write code here
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (s.charAt(i) == ')' && stack.peek() != '(')
                    return false;
                if (s.charAt(i) == ']' && stack.peek() != '[')
                    return false;
                if (s.charAt(i) == '}' && stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[(]){}";
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid(s));
    }
}
