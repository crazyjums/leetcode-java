package utils.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 */
public class SingleQueue {
    private Deque<Integer> deque = new LinkedList<>();

    public void push(int value){
        while (!this.deque.isEmpty() && value > this.deque.getLast()){
            this.deque.removeLast();
        }
        this.deque.addLast(value);
    }

    public int peek(){
        if (this.deque.isEmpty())
            return -1;
        return this.deque.getFirst();
    }


    public static void main(String[] args) {
        SingleQueue singleQueue = new SingleQueue();
        singleQueue.push(1);
        singleQueue.push(3);
        singleQueue.push(1);
        singleQueue.push(2);
        singleQueue.push(0);
        singleQueue.push(5);

        System.out.println(singleQueue.peek());

    }

}
