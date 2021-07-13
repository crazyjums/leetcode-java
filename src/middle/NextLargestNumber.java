package middle;

import utils.ListNode;
import utils.MyPrintFunction;

import java.util.ArrayList;
import java.util.List;

public class NextLargestNumber {

    public int[] solution(ListNode head) {
        List<Integer> resList=new ArrayList<>();
        if (head.next == null) {
            resList.add(0);
            return MyPrintFunction.listTo1DArray(resList);
        }
        ListNode cur = head;
        while (cur != null) {
            ListNode inCur = cur;
            while (true) {
                if (inCur == null) {
                    resList.add(0);
                    break;
                } else {
                    if (inCur.val > cur.val) {
                        resList.add(inCur.val);
                        break;
                    }
                }
                inCur = inCur.next;
            }

            cur = cur.next;
        }
        return MyPrintFunction.listTo1DArray(resList);
    }

    private int[] getIntArray(ListNode p){
        ListNode cur= p;
        List<Integer> res = new ArrayList<>();
        while (cur!=null){
            res.add(cur.val);
            cur=cur.next;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(2);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(1);

        p1.next = p2;
        p2.next = p3;
        p3.next=p4;
        ListNode.printList(p1);

        NextLargestNumber nextLargestNumber = new NextLargestNumber();
        int[]res = nextLargestNumber.solution(p1);
        MyPrintFunction.print(res);
    }
}
