package utils.lru;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer,Integer> hashMap;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)){
            int v = hashMap.get(key);
            hashMap.remove(key);
            hashMap.put(key,v);
            return v;
        }else
            return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)){
            hashMap.remove(key);
            hashMap.put(key,value);
        }else if (hashMap.size()>=this.capacity){
            int dKey = hashMap.keySet().iterator().next();
            hashMap.remove(dKey);
            hashMap.put(key,value);
        }else{
            hashMap.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        System.out.println(lruCache.get(2));
        lruCache.put(2,6);
        System.out.println(lruCache.get(1));
        lruCache.put(1,5);
        lruCache.put(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
