package utils.queue;

import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackToQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int vaule) {
        stack1.push(vaule);
    }

    public int pop() {
        if (stack1.isEmpty())
            return Integer.MIN_VALUE;
        if (!stack2.isEmpty())
            return stack2.pop();
        else{
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
        System.out.println(stackToQueue.pop());
        stackToQueue.push(4);
        System.out.println(stackToQueue.pop());
        stackToQueue.push(5);
        System.out.println(stackToQueue.pop());
    }
}
