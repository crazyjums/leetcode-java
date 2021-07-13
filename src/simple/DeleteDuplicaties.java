package simple;

import utils.ListNode;

public class DeleteDuplicaties {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(1);
        root.next.next.next.next = new ListNode(1);
        root.next.next.next.next.next = new ListNode(8);

        System.out.println("原始：");
        ListNode.printList(root);
        DeleteDuplicaties deleteDuplicaties = new DeleteDuplicaties();
        ListNode res = deleteDuplicaties.deleteDuplicaties(root);
        System.out.println("去重：");
        ListNode.printList(res);
    }

    public ListNode deleteDuplicaties(ListNode root){
        if (null==root)
            return root;
        else if(root.next==null)
            return root;
        ListNode cur1 = root;
        while (null!=cur1 && null != cur1.next){
            ListNode cur2 = cur1.next;
            if (cur2.val == cur1.val){
                cur1.next = cur2.next;
            }else{
                cur1 = cur1.next;
            }
        }
        return root;
    }

}
