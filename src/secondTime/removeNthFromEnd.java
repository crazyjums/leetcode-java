package secondTime;

import utils.ListNode;
import utils.MyPrintFunction;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||head.next==null)return null;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        int i=0;
        ListNode p1 = pre;
        while(i<n&&p1!=null){
            p1 = p1.next;
            i++;
        }
        ListNode p2 = pre;
        while(p1!=null&&p1.next!=null){
            p1=p1.next;
            p2=p2.next ;
        }
        p2.next = p2.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode p1 =new ListNode(1);
        p1.next = new ListNode(2);
        MyPrintFunction.print(p1);
        ListNode res = new removeNthFromEnd().removeNthFromEnd(p1,1);
        MyPrintFunction.print(res);
    }

}
