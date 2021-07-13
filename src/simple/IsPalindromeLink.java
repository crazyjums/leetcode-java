package simple;

import utils.ListNode;

import java.util.Stack;

public class IsPalindromeLink {
    public boolean isPalindrome(ListNode head) {
        if (head==null)
            return false;
        if (head.next==null)
            return true;
        Stack<Integer>stack=new Stack<>();
        ListNode p = head;
        while (p!=null){
            stack.push(p.val);
            p=p.next;
        }
        ListNode p2=head;
        while (!stack.isEmpty()&&p2!=null){
            System.out.println(stack.peek() + "  "+p2.val);
            if (stack.peek()!=p2.val)
                return false;
            stack.pop();
            p2=p2.next;
        }
        return  true;
    }

    private ListNode reverse(ListNode p){
        ListNode newHead = null;
        ListNode pre= null;
        ListNode cur=p;
        while (cur!=null){
            ListNode next = cur.next;
            if (next==null)
                newHead=cur;
            cur.next=pre;
            pre=cur;
            cur=next;

        }
        return newHead;
    }

    public boolean solution(ListNode head){
        if (head==null||head.next==null)
            return true;
        if (head.next.next==null){
            if (head.val!=head.next.val)
                return false;
        }
        ListNode p = head;
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode p2 = reverse(slow);
        while (p!=null&&p2!=null){
            if (p.val!=p2.val)
                return false;
            p=p.next;
            p2=p2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(0);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(1);

        p1.next=p2;
        p2.next=p3;
        p3.next=p4;
        ListNode.printList(p1);

        IsPalindromeLink isPalindromeLinkv =new IsPalindromeLink();

        System.out.println(isPalindromeLinkv.solution(p1));
    }
}
