package simple;

import utils.ListNode;

public class GetKthFromEnd {
    public static ListNode solution(ListNode p,int k) {
        if (p == null)
            return null;
        int i=1;
        ListNode f=p;
        ListNode s=p;
        while (f.next!=null&&i++<k)
            f=f.next;
        while (f.next!=null){
            s=s.next;
            f=f.next;
        }
        return s;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        ListNode res = solution(p1,4);
        ListNode.printList(res);
    }
}
