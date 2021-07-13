package utils.lru;

public class DoubleLink {
    private DNode head,tail;//虚节点

    private int size;
    public DoubleLink() {
        size=0;
        this.head = new DNode(0,0);
        this.tail = new DNode(0,0);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }


    public void addLast(DNode x){
        if (this.size==0){
            this.head.next = x;
            x.pre = this.head;
            x.next = this.tail;
            this.tail.pre = x;
            size++;
        }else{
            this.tail.pre.next = x;
            x.pre = this.tail.pre;
            x.next = this.tail;
            this.tail.pre = x;
            size++;
        }
    }

    public DNode removeFirst(){
        if (this.head.next == this.tail)
            return null;
        DNode first = this.head.next;
        removeNode(first);
        return first;
    }

    /**
     * 假设双链表不空，
     * @param x
     * @return
     */
    public int removeNode(DNode x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
        return x.val;
    }

    public void printDoubleLink(){
        DNode cur = this.head;
        while (cur.next!=this.tail){
            cur = cur.next;
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleLink doubleLink = new DoubleLink();
        DNode d1 = new DNode(1,2);
        DNode d2 = new DNode(2,22);
        DNode d3 = new DNode(3,43);
        DNode d4 = new DNode(4,50);
        doubleLink.addLast(d1);
        doubleLink.addLast(d2);
        doubleLink.addLast(d3);
        doubleLink.printDoubleLink();
        doubleLink.removeFirst();
        doubleLink.addLast(d4);
        doubleLink.printDoubleLink();

//        doubleLink.removeFirst();
        doubleLink.removeNode(d2);
        doubleLink.printDoubleLink();
    }
}
