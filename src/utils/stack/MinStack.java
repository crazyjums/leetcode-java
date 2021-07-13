package utils.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MinStack {
    private Deque<Integer> stack1 = new ArrayDeque<>();//用来存放原始数据
    private Deque<Integer> stack2 = new ArrayDeque<>();//用来存放最小值


    public int pop() {
        if (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peekLast().equals(stack2.peekLast()))
            stack2.pollLast();
        return stack1.isEmpty()?Integer.MIN_VALUE:stack1.pollLast();
    }

    public void push(int value) {
        stack1.addLast(value);
        if (stack2.isEmpty() || value <= stack2.peekLast())
            stack2.addLast(value);
    }

    public int getMin() {
        if (stack1.isEmpty())
            return Integer.MIN_VALUE;
        return stack2.peekLast();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(9);
        minStack.push(7);
        minStack.push(3);
        minStack.push(8);
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
