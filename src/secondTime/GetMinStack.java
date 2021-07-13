package secondTime;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

public class GetMinStack {
    /**
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> deque = new Stack<>();
    public int[] getMinStack (int[][] op) {
        // write code here
        List<Integer>res=new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            if (op[i][0]==1){
                push(op[i][1]);
            }else if (op[i][0]==2){
                pop();
            }else if (op[i][0]==3)
            {
                int min = getMin();
                res.add(min);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void push(int val) {
        stack.push(val);
        if (deque.isEmpty() || val <= deque.peek())
            deque.push(val);
    }

    public int pop() {
        if (!stack.isEmpty() && !deque.isEmpty() && deque.peek().equals(stack.peek()))
            deque.pop();
        return stack.pop();
    }

    public int getMin() {
        if (stack.isEmpty())
            return -1;
        return deque.peek() < stack.peek() ? deque.peek() : stack.peek();
    }

    public static void main(String[] args) {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(8);
        getMinStack.push(4);
        getMinStack.push(6);
        getMinStack.pop();
        getMinStack.push(1);
        getMinStack.push(3);
        System.out.println(getMinStack.getMin());
    }
}
