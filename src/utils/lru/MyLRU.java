package utils.lru;

import java.util.HashMap;

public class MyLRU {
    private DoubleLink cache;
    private HashMap<Integer, DNode> hashMap;
    private int capcity;

    public MyLRU(int cap) {
        this.capcity = cap;
        cache = new DoubleLink();
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key))
            return -1;
        makeRecently(key);
        return hashMap.get(key).val;
    }

    public void put(int key, int val) {
        if (hashMap.containsKey(key)) { //如果包含该元素，则调整顺序
            DNode x = hashMap.get(key);
            hashMap.remove(x);
            cache.removeNode(x);
            DNode newNode = new DNode(key,val);
            hashMap.put(key,newNode);
            cache.addLast(newNode);
        } else if (hashMap.size() >= capcity) {//超出缓冲区大小
            addRecently(key, val);
        } else {
            DNode newNode = new DNode(key, val);
            cache.addLast(newNode);
            hashMap.put(key, newNode);
        }
    }

    /**
     * 将key调整到双链表尾部
     *
     * @param key
     */
    private void makeRecently(int key) {
        DNode x = hashMap.get(key);
        cache.removeNode(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        DNode x = cache.removeFirst();
        hashMap.remove(x.key);

        DNode newNode = new DNode(key, val);
        cache.addLast(newNode);
        hashMap.put(key, newNode);
    }

    public static void main(String[] args) {
        MyLRU myLRU = new MyLRU(5);
        myLRU.put(1, 100);
        myLRU.put(2, 200);
        myLRU.put(3, 300);
        myLRU.put(4, 400);
        myLRU.put(5, 500);
        System.out.println(myLRU.get(1));
        myLRU.put(5, 600);
//        System.out.println(myLRU.get(1));
//        System.out.println(myLRU.get(2));
//        System.out.println(myLRU.get(3));
//        System.out.println(myLRU.get(4));
        System.out.println(myLRU.get(5));
        System.out.println(myLRU.get(6));

    }

}
