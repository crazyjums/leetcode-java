package middle;

import utils.ListNode;

import java.util.ArrayList;
import java.util.List;


public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(3);

        ListNode c1 = l1;
        List<Integer> a = new ArrayList<>();
        while (c1 != null) {
            a.add(c1.val);
            c1 = c1.next;
        }
        for (int i = a.size() - 1; i > -1; i--) {
            System.out.print(a.get(i));
        }
        System.out.print("+");
        ListNode c2 = l2;
        List<Integer> b = new ArrayList<>();
        while (c2 != null) {
            b.add(c2.val);
            c2 = c2.next;
        }
        for (int i = b.size() - 1; i > -1; i--) {
            System.out.print(b.get(i));
        }
        System.out.print("=");

        ListNode res = addTwoNumbers.solution(l1, l2);
        List<Integer> c = new ArrayList<>();
        while (res != null) {
            c.add(res.val);
            res = res.next;
        }
        for (int i = c.size() - 1; i > -1; i--) {
            System.out.print(c.get(i));
        }
    }

    public ListNode solution(ListNode l1, ListNode l2) {
        int f = 0;
        ListNode res = new ListNode();
        ListNode origin = res;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            if (n1 + n2 + f >= 10) {
                res.val = n1 + n2 + f - 10;
                f = 1;
            } else {
                res.val = n1 + n2 + f;
                f = 0;
            }
            if (null != l1) {
                l1 = l1.next;
            }
            if (l2 != null)
                l2 = l2.next;

            if (l1 != null || l2 != null) {
                res.next = new ListNode();
                res = res.next;
            }
        }
        if (f == 1) {
            res.next = new ListNode(f);
        }

        return origin;
    }
}
