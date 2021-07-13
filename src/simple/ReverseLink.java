package simple;

import org.omg.CORBA.PUBLIC_MEMBER;
import utils.ListNode;

public class ReverseLink {
    public static ListNode solution(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        ListNode np=head,pre=null;
        ListNode newHead=null;
        while (np!=null){
            ListNode next = np.next;
            if (next==null){
                newHead=np;
            }
            np.next=pre;
            pre=np;
            np=next;

        }
        return newHead;
    }

    public static boolean hasCycle(ListNode head) {
        if (head==null||head.next==null)
            return false;
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast)
                return true;
        }
        return false;
    }

    public static void show(ListNode p) {
        ListNode c = p;
        while (c != null) {
            if (c.next == null)
                System.out.print(c.val);
            else
                System.out.print(c.val + "->");
            c = c.next;
        }
        System.out.println();
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
//        p5.next = p2;
//        show(p1);
        show(p1);
        ListNode res=solution(p1);
        show(res);
        show(p1);
        System.out.println();
    }
}
