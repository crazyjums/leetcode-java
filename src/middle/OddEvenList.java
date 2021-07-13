package middle;

import utils.ListNode;
import utils.MyPrintFunction;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode evenHead = head.next;
        ListNode oddHead = head;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return oddHead;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLink();
        MyPrintFunction.print(head);
        ListNode res = new OddEvenList().oddEvenList(head);
        MyPrintFunction.print(res);
    }
}
