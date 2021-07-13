package test;

import utils.ListNode;
import utils.MyPrintFunction;

public class T1 {
    public static String solution(String s,int k){
        return null;
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode left = dummy;

        ListNode right = new ListNode(0);
        ListNode right_head = right;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = right_head.next;
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode head = ListNode.getLink2();
        MyPrintFunction.print(head);
        ListNode res = partition(head, 3);
        MyPrintFunction.print(res);
    }
}
