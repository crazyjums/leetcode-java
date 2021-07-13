package simple;

import middle.MyLinkedList;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next=null;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len=0;
        while (cur.next!=null){
            cur=cur.next;
            len++;
        }
        System.out.println(len);
        cur=head;
        for (int i = 0; i < len-n; i++) {
            cur=cur.next;
        }
        ListNode temp = cur.next;
        cur=temp.next;
        return head;
    }

    public void printLink(ListNode head){
        ListNode cur=head;
        while (cur.next!=null){
            cur=cur.next;
            System.out.print(cur.val+",");
        }
    }


    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        int n = 3;
        ListNode head = new ListNode();
        head.next=new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        removeNthFromEnd.printLink(head);
        System.out.println(removeNthFromEnd.removeNthFromEnd(head,n).val);
        removeNthFromEnd.printLink(head);
    }
}
