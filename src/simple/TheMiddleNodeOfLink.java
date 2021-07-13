package simple;

import utils.ListNode;

public class TheMiddleNodeOfLink {
    public static int solution(ListNode p) {
        if (p == null)
            return -1;
        ListNode s = p;
        ListNode f = p;
        while (f.next!=null){
            s=s.next;
            f=f.next.next;

        }
        return s.val;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.getLink();
        ListNode.printList(p);
        int mid = solution(p);
        System.out.println(mid);
    }
}
