package middle;

import utils.ListNode;
import utils.MyPrintFunction;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
             h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        node6.next = node7;
        node7.next = node3;

        ListNode res = new GetIntersectionNode().getIntersectionNode(node1, node7);
        MyPrintFunction.print(res);
    }
}
