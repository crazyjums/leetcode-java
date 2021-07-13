package middle;

import utils.ListNode;

public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)
            return head;
        int n = 0;
        ListNode p1 = head;
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        while (p1 != null) {
            n++;
            p1 = p1.next;
        }
        int move = k % n; //虚拟头结点指向的倒数第k个节点
        ListNode slow = head;
        ListNode fast = head;
        int i = 0;
        while (i < move) {
            fast = fast.next;
            i++;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next = newHead.next;
        newHead.next = slow.next;
        slow.next = null;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = null;ListNode.getLink();
        ListNode.printList(head);
        ListNode res = rotateRight(head, 3);
        ListNode.printList(res);
    }

}
