package middle;

import utils.ListNode;
import utils.MyPrintFunction;

public class DeleteDuplicateList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            int curV = cur.val;
            if (cur.next != null && cur.next.val == curV) {
                while (cur.next != null && cur.next.val == curV) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        MyPrintFunction.print(node1);
        ListNode res = new DeleteDuplicateList().deleteDuplicates(node1);
        MyPrintFunction.print(res);
    }
}
