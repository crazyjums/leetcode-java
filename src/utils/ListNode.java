package utils;

public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static void printList(ListNode root) {
        ListNode cur = root;
        while (null != cur) {
            int t = cur.val;
            cur = cur.next;
            if (cur != null)
                System.out.print(t + "->");
            else
                System.out.print(t);
        }
        System.out.println();
    }

    public static ListNode getLink() {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        return p1;
    }

    public static ListNode getLink2() {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(4);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(2);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(2);
        ListNode p7 = new ListNode(7);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        return p1;
    }

}
