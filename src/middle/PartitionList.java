package middle;

import utils.ListNode;
import utils.MyPrintFunction;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode left_head = new ListNode(-1);
        ListNode left = left_head;
        ListNode right_head = new ListNode(-1);
        ListNode right = right_head;

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
        return left_head.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode res = new PartitionList().partition(node1, 3);
        MyPrintFunction.print(res);
    }
}
