package middle;

public class MyCircularQueue {
    private int f, r;
    private final int k;
    private final int[] a;

    public MyCircularQueue(int k) {
        this.k = k + 1;
        this.f = this.r = 0;
        this.a = new int[k];
    }


    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        this.a[this.r] = value;
        this.r = (this.r + 1) % this.k;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        this.f = (1 + this.f) % this.k;
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
        return this.a[(this.r - 1) % this.k];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.f == this.r;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (this.r + 1) % this.k == this.f;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.Rear());
        myCircularQueue.deQueue();
        System.out.println(myCircularQueue.Front());

    }
}
