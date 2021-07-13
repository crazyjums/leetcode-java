package middle;

import utils.ListNode;
import utils.MyPrintFunction;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = getLength(head);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //使用归并排序算法，从下往上进行归并
        for (int i = 1; i < n; i *= 2) {
            ListNode pre = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur; //第一部分的头部节点
                ListNode h2 = split(h1, i); //第二部分的头结点
                cur = split(h2, i); //剩余部分的头结点
                ListNode tem = merge(h1, h2); //合并两个链表
                pre.next = tem; //将合并后的链表连接到前面的尾部
                while (pre.next != null) //将pre移动到排好序的链表的尾部
                    pre = pre.next;
            }
        }

        return dummy.next;
    }

    private int getLength(ListNode head) {
        if (head == null) return 0;
        int c = 0;
        while (head != null) {
            c ++;
            head = head.next;
        }
        return c;
    }


    private ListNode merge(ListNode left, ListNode right) {
        // 定义合并链表的指针
        ListNode h = new ListNode(-1);
        ListNode p = h; //返回的指针
        //merge 两个链表
        while (left != null && right != null) {
            if (left.val > right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //将后续买有merge完的链表连接到组合链表的尾部
        h.next = left != null ? left : right;
        return p.next;
    }


    //将一个链表分割成两个，返回后半部分的头结点
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null;
        return right;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getLink();
        MyPrintFunction.print(head);
        ListNode res = new SortList().sortList(head);
        MyPrintFunction.print(res);
    }
}
