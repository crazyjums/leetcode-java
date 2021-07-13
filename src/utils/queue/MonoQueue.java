package utils.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 单调队列
 */
public class MonoQueue {
    private boolean up = true;
    private Queue<Integer> queue = new LinkedList<>();

    public MonoQueue(boolean up) {
        this.up = up;
    }

    public MonoQueue() {
    }

    public void pop(int value) {
        if (!this.queue.isEmpty() && this.queue.peek() == value)
            this.queue.poll();
    }

    public void push(int value) {
        if (this.queue.isEmpty()) {
            this.queue.add(value);
        } else {
            if (up) //单调递增队列
                while (!this.queue.isEmpty() && value > this.queue.peek())
                    this.queue.poll();
            else //单调递减队列
                while (!this.queue.isEmpty() && value < this.queue.peek())
                    this.queue.poll();
            this.queue.add(value);
        }
    }

    public int peek() {
        return this.queue.peek();
    }


    public static void main(String[] args) {
        MonoQueue monoQueue = new MonoQueue(false);
        monoQueue.push(1);
        monoQueue.push(3);
        monoQueue.push(1);
        monoQueue.push(2);
        monoQueue.push(0);
        monoQueue.push(5);

        System.out.println(monoQueue.peek());
    }
}
