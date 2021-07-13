package simple;

import middle.MyLinkedList;
import utils.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();
        l1.addAtTail(1);
        l1.addAtTail(2);
        l1.addAtTail(4);

        l2.addAtTail(1);
        l2.addAtTail(3);
        l2.addAtTail(4);

        ListNode head = mergeTwoLists.mergeTwoLists3(l1.head.next, l2.head.next);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null) return null;
        if (l1==null&&l2!=null) return l2;
        if (l1!=null&&l2==null) return l1;
        ListNode newHead = new ListNode(-1);
        ListNode p = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        newHead.next = ((l1==null)?l2:l1);//最后没有比完的全部链接上
        return p.next;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2){
        ListNode cur=l1;
        l1=l1.next;
        ListNode head=cur;
        while (l1!=null&&l2!=null){
            if (cur.val<=l2.val){
                cur.next = l2;
                l2=l2.next;
                cur=cur.next;
            }else if(cur.val<=l1.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            }
        }
        return head;
    }
}
