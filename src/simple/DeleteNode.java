package simple;

import utils.ListNode;

public class DeleteNode {
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode newHHead = new ListNode(-1);
        newHHead.next=head;
        ListNode cur = head;
        ListNode pre = newHHead;
        while (cur!=null){
            if (cur.val==val&&cur.next!=null){
                pre.next = cur.next;
            }
            if (cur.val==val&&cur.next==null){
                pre.next=null;
            }
            cur=cur.next;
            pre=pre.next;
        }
        return newHHead.next;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.getLink();
        ListNode.printList(p);
        ListNode res = deleteNode(p,3);
        ListNode.printList(res);
    }
}
