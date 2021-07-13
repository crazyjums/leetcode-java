package secondTime;

import utils.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
        ListNode p=new ListNode();
        ListNode head=p;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p=p.next;
        }

        p.next = l1!=null?l1:l2;
        return head.next;
    }

    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    private ListNode p = null;
    private ListNode head = p;
    public ListNode merge(ListNode l1, ListNode l2){
        //退出条件
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        if (l1 == null && l2 == null) return null;//那么， ;
        //2.当前逻辑
        if (l1.val<=l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        ListNode p = new MergeTwoLists().merge(l1, l2);
        ListNode.printList(p);
    }
}
