package utils.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class IncreaseStack {
    Deque<Integer> stack = new ArrayDeque<>();

    public void add(int val){
        while (!stack.isEmpty() && val <= stack.peekLast()){
            stack.pollLast();
        }
        stack.addLast(val);
    }

    public int peek(){
        if (!stack.isEmpty())
            return stack.peekLast();
        return -1;
    }

    public int pop(){
        if (!stack.isEmpty())
            return stack.pollLast();
        return -1;
    }

    public static void main(String[] args) {
        IncreaseStack increaseStack = new IncreaseStack();
        increaseStack.add(4);
        increaseStack.add(10);
        increaseStack.add(6);
//        increaseStack.add(12);
        System.out.println(increaseStack.peek());
        increaseStack.pop();
        System.out.println(increaseStack.peek());
        increaseStack.pop();
        System.out.println(increaseStack.peek());
        increaseStack.pop();
        System.out.println(increaseStack.peek());
    }
}
