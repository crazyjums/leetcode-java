package hard;

import utils.ListNode;
import utils.MyPrintFunction;

import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        /**
         * 思路：使用优先队列进行解题，（最小堆）
         *      将所有节点放入优先队列，每次取出一个值最小的节点拼接到新的节点上，然后继续遍历下一个
         */

        ListNode newHead = new ListNode(-1);
        if (lists==null||lists.length==0)return newHead.next;
        ListNode head = newHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.val,o2.val)));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i]!=null)
            queue.add(lists[i]);
        }
        while (!queue.isEmpty()){
            ListNode cur = queue.poll();
            head.next = cur;
            head = head.next;
            if (cur.next!=null)queue.add(cur.next);
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode [] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next=new ListNode(4);
        lists[0].next.next=new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next=new ListNode(3);
        lists[1].next.next=new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next=new ListNode(6);


        ListNode res = new MergeKLists().mergeKLists(lists);
        MyPrintFunction.print(res);
    }
}
