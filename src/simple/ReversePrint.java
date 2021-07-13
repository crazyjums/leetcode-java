package simple;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePrint {
    public static int[] solution(ListNode head){
        if (head==null)
            return new int[0];
        if (head.next==null)
            System.out.println(head.val);
        Stack<Integer> s = new Stack<>();
        List<Integer> res=new ArrayList<>();
        ListNode p = head;
        int c=0;
        while (p!=null){
            s.push(p.val);
            p=p.next;
            c++;
        }
        int i=0;
        while (!s.isEmpty()){
            res.add(s.pop());
        }
        int[]res2=new int[c];
        for (int j = 0; j < c; j++) {
            res2[j]=res.get(j);
        }
        return res2;
    }

    public static void main(String[] args) {
        ListNode q = null;
        ListNode p = new ListNode(1);
        p.next = new ListNode(2);
        p.next.next = new ListNode(3);
        int[]res=solution(p);
        System.out.println(Arrays.toString(res));
    }
}
