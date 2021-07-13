package middle;

import utils.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddTwoNumbersll {
    public static ListNode solution(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new LinkedList<>(), s2 = new LinkedList<>(), res = new LinkedList<>();
        while (l1 != null) {
            s1.addLast(l1.val);
            if (l1.next != null)
                l1 = l1.next;
            else
                break;
        }
        while (l2 != null) {
            s2.addLast(l2.val);
            if (l2.next != null)
                l2 = l2.next;
            else
                break;
        }

        int f = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peekLast() + s2.peekLast() + f >= 10) {
                res.addLast(s1.pollLast() + s2.pollLast() + f - 10);
                f = 1;
            } else {
                res.addLast(s1.pollLast() + s2.pollLast() + f);
                f = 0;
            }
        }

        while (!s1.isEmpty()) {
            if (s1.peekLast()+f>=10) {
                res.addLast(s1.pollLast() + f-10);
                f = 1;
            } else{
                res.addLast(s1.pollLast()+f);
                f=0;
            }
        }
        while (!s2.isEmpty()) {
            if (s2.peekLast()+f>=10) {
                res.addLast(s2.pollLast() + f-10);
                f = 1;
            } else{
                res.addLast(s2.pollLast()+f);
                f=0;
            }
        }
        if (f==1){
            res.addLast(1);
        }


        ListNode l3 = new ListNode(res.pollLast());
        ListNode p = l3;
        while (!res.isEmpty()) {
            l3.next = new ListNode(res.pollLast());
            l3 = l3.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode res = solution(l1, l2);
        while (res != null ) {
            System.out.print(res.val + "->");
            if (res.next != null)
                res = res.next;
            else
                break;
        }
    }
}
