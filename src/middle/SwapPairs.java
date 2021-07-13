package middle;

import utils.ListNode;

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next=head;
        ListNode cur=newHead;
        while (cur.next != null &&cur.next.next!=null){
            ListNode node1 = cur.next;
            ListNode node2= cur.next.next;

            node1.next = node2.next;
            node2.next = node1;
            cur.next = node2;

            cur=cur.next.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.getLink();
        ListNode.printList(p);
        ListNode res = swapPairs(p);
        ListNode.printList(res);
    }
}
