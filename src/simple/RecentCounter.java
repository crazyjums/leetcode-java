package simple;

import java.util.*;

public class RecentCounter {
    private Queue<Integer> count = new LinkedList<>();
    public RecentCounter() {

    }

    public int ping(int t) {
        while (!this.count.isEmpty() && t-this.count.peek()>3000)
            this.count.poll();
        this.count.add(t);
        return this.count.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

    }
}
