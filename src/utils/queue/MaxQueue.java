package utils.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MaxQueue {
    /**
     * 结合单调队列实现
     */
    private Queue<Integer> queue1;// = new LinkedList<>();//主队列
    private Deque<Integer> queue2;// = new LinkedList<>();//单调队列

    public MaxQueue() {
        queue1 = new LinkedList<>();//主队列
        queue2 = new LinkedList<>();//单调队列
    }

    public int max_value() {
        return queue2.isEmpty()?-1:queue2.getFirst();
    }

    public void push_back(int value) {
        queue1.add(value);
        while (!queue2.isEmpty() && value > queue2.getLast())
            queue2.removeLast();
        queue2.addLast(value);
    }

    public int pop_front() {
        if (queue1.isEmpty())
            return -1;
        if (queue1.peek().equals(queue2.getFirst()))
            queue2.removeFirst();
        return queue1.poll();
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println("null");
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(46);
        System.out.println("null");
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(868);
        System.out.println("null");
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(525);
        System.out.println("null");
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(123);
        System.out.println("null");
        maxQueue.push_back(646);
        System.out.println("null");
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(229);
        System.out.println("null");

//        System.out.println(maxQueue.pop_front());
//        System.out.println(maxQueue.pop_front());
//        System.out.println(maxQueue.pop_front());
//        maxQueue.push_back(9);
//        maxQueue.push_back(8);
//        System.out.println(maxQueue.max_value());
//        maxQueue.pop_front();
//        maxQueue.pop_front();
//        System.out.println(maxQueue.max_value());
//        maxQueue.push_back(11);
//        maxQueue.pop_front();
//        maxQueue.pop_front();
//        System.out.println(maxQueue.max_value());
    }
}
