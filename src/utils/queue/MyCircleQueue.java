package utils.queue;

public class MyCircleQueue {
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */

    private int[] a;
    private int k;
    private int f, r; // 头指针和尾指针

    public MyCircleQueue(int k) {
        this.k = k+1;
        this.f = this.r = 0;
        this.a = new int[this.k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) { //判断队列是否满
            return false;
        }
        this.a[this.r] = value;
        this.r = (this.r+1) % this.k;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {  //队列为空
            return false;
        }
        this.f = (1+this.f) % this.k;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return this.a[this.f];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        return this.a[(this.r-1+this.k)%this.k];  //this.r-1+this.k  为了防止r==0时出现-1的下标越界的异常
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.f==this.r;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.f==(this.r+1)%this.k;
    }

    public static void main(String[] args) {
        MyCircleQueue circularQueue = new MyCircleQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(9));// 返回 true
        System.out.println(circularQueue.enQueue(5));// 返回 true
        System.out.println(circularQueue.enQueue(0));// 返回 false
        System.out.println(circularQueue.Rear());//5
        System.out.println(circularQueue.isFull());//true
        System.out.println(circularQueue.deQueue());//true
        System.out.println(circularQueue.isFull());//false
        System.out.println(circularQueue.Front());//9
        System.out.println(circularQueue.Rear());//5
        System.out.println(circularQueue.enQueue(0));// 返回 true
        System.out.println(circularQueue.isFull());//true
        System.out.println(circularQueue.Rear());//0
    }
}
