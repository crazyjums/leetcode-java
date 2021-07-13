package secondTime;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintListFromTailToHead {
    private static ArrayList<Integer> res = new ArrayList<>();
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p!=null){
            stack.push(p.val);
            p=p.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode p =ListNode.getLink();
        ListNode.printList(p);
        List<Integer> res = printListFromTailToHead(p);
        System.out.println(res);
    }
}
