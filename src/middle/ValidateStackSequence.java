package middle;

import java.util.Stack;

public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        /**
         * 思路：
         *   - 使用一个栈作为辅助栈，根据pushed列表向辅助栈中push元素，
         *   - 然后判断辅助栈顶元素和poped的第j个元素是否相等，如果相等，
         *   则辅助栈中的元素弹出，poped的索引j也加1，直到辅助栈中没有与poped相等元素之后，继续遍历pushed数组
         *
         *   - 最后判断辅助栈是否为空，如果为空的话，则表示是一个合法的弹出和压入序列
         *   否则不是
         */
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int []push = {1,2,3,4,5};
        int[] pop ={4,5,3,1,2};
        ValidateStackSequence validateStackSequence = new ValidateStackSequence();
        boolean res = validateStackSequence.validateStackSequences(push,pop);
        System.out.println(res);
    }

}
