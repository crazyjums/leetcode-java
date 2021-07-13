package middle;

import utils.ListNode;

/**
 * 判断链表是否有环
 */
public class IsCycle {
    /**
     * 追赶理论：当两个人在一个环形跑道上跑步时，只要其中一个人的速度比另一个人的速度快，
     * 那么只要给足够多的时间。该速度快的人一定能追上那个速度慢的人。
     * 思路：
     * 使用两个指针，一个慢指针，一次移动一格，
     * 一格快指针，一次移动两格，最终会追赶上
     *
     * @param root
     * @return
     */
    public boolean isCycle(ListNode root) {
        if (root==null||root.next==null)
            return false;
        ListNode p1 = root, p2 = root;
        while (p1 != null && p2!=null&&p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 思路：
     * 当两个指针相遇之后，他们继续继续跑，因为快指针比慢指针快一倍，即
     * 快指针一次移动两格。慢指针一次移动一格。那么从同一个起点开始跑时，
     * 他们最终会相遇，此时快指针比满指针多跑了一圈。只要计算慢指针所跑的
     * 路程就可以知道环的长度
     *
     * @param root
     * @return
     */
    public int howCycleLong(ListNode root) {
        if (root == null || root.next == null)
            return -1;
        ListNode p1 = root, p2 = root;
        int cycleLong = 0;
        int meetTime = 0;
        while (p1 != null && p2!=null&&p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (meetTime == 1)
                cycleLong++;
            if (meetTime == 2)
                break;
            if (p1 == p2) {
                meetTime++;
            }
        }
        return cycleLong;
    }

    /**
     * 获得环的头结点
     * 思路：
     * 假设从链表的头结点到环头结点的距离为D，环头结点到p1和p2首次相遇的节点处的
     * 距离为S1，抽次相遇的节点到头结点的另一半的距离为S2，
     * 由于：
     * - p1指针一次走一步
     * - p2指针一次走两步
     * 所以在p1和p2相遇时，两个指针走过的路程如下：
     * p1 = D + S1
     * P2 = D + S1 + S1 + S2
     * 由于p2比p1快一倍，所以p2所走的路程是p1走的路程的两倍
     * 即： 2(D+S1)=D+2*S1+S2 => 2*D + 2*S2 = D+ 2*S1 + S2 => D=S2
     * 此时：将p1指针放回到头指针，然后让p1和p2以相同的步长前进，最终当p1和p2相等时，
     * 便是停留在环的头结点上
     *
     * @param root
     * @return
     */
    public ListNode getStartCycle(ListNode root) {
        if (root == null || root.next == null)
            return null;
        ListNode p1 = root, p2 = root;
        while (p1 != null && p2!=null&&p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2)
                break;
        }
        if (p1 != p2){
            return null;
        }
        p1 = root;
        while (p1 != p2 && p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(10);
        ListNode node7 = new ListNode(20);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;

        IsCycle isCycle = new IsCycle();

        System.out.println(isCycle.isCycle(node1));
        System.out.println(isCycle.howCycleLong(node1));
        ListNode res = isCycle.getStartCycle(node1);
        if (res == null)
            System.out.println(res);
        else
            System.out.println(res.val);

    }
}
