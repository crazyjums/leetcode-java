package utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyLRU extends LinkedHashMap<Integer, Integer> {
//    private LinkedHashMap<Integer, Integer> map;
    private int capacity;
    public MyLRU(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

    }

    public boolean removeEdlstNode(Map.Entry<Integer, Integer> node) {
        return size() > capacity;
    }
}
