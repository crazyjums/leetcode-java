package middle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
                    tokens[i].equals("*") || tokens[i].equals("/")) {
                int b = Integer.parseInt(stack.pollLast());
                int a = Integer.parseInt(stack.pollLast());
                int c = 0;
                if (tokens[i].equals("+"))
                    c = a + b;
                else if (tokens[i].equals("-"))
                    c = a - b;
                else if (tokens[i].equals("*"))
                    c = a * b;
                else
                    c = a / b;
                stack.addLast(String.valueOf(c));
            } else
            stack.addLast(tokens[i]);
        }
        return Integer.parseInt(stack.peekLast());
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().evalRPN(tokens));
        Map<String, Integer> map = new HashMap<>();
        map.put("11",2);
        map.put("asdf",345);
        System.out.println(map);
    }
}
