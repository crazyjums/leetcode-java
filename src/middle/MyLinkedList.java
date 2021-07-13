package middle;

import java.util.Arrays;
import utils.ListNode;

public class MyLinkedList {



    public ListNode head;
    private int length = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.head = new ListNode();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= this.length || index < 0) {
            return -1;
        }
        ListNode cur = this.head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(this.length, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        ListNode newNode = new ListNode(val);
        if (index>length)
            return;
        if (index<0)
            index=0;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        newNode.next = cur.next;
        cur.next=newNode;
        length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index>=length || index<0)
            return;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        cur.next = cur.next.next;
        length--;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len=0;
        while (cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur=head;
        for (int i = 0; i < len-n; i++) {
            cur=cur.next;
        }
        cur.next = cur.next.next;
        return head;
    }

    public void printLink(){
        if (length==0)
            return;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i]=get(i);
        }
        System.out.println(Arrays.toString(res));
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtTail(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtTail(5);
        myLinkedList.printLink();
        myLinkedList.removeNthFromEnd(myLinkedList.head, 2);
        myLinkedList.printLink();
    }
}
