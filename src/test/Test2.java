package test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Test2 {
    private LinkedHashMap<Integer, Integer> map;
    private int cap;

    public Test2(int cap) {
        this.cap = cap;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if (map.containsKey(key)) {
            map.replace(key, val);
        } else if (map.size() >= this.cap) {
            int dkey = map.keySet().iterator().next();
            map.remove(dkey);
            map.put(key, val);
        } else
            map.put(key, val);

    }

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Test2 lru = new Test2(n);
//        char c = scanner.next().charAt(0);
//        while (scanner.hasNextLine()){
//            if (n>0&&c=='p'){
//                int k = scanner.nextInt();
//                int v = scanner.nextInt();
//                lru.put(k,v);
//            }else if (n>0&&c=='g'){
//                int k = scanner.nextInt();
//                int res = lru.get(k);
//                System.out.println(res);
//            }
//            c = scanner.next().charAt(0);
//        }
//    }
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.print("foo");
            }
        };
        Thread t = new Thread(runnable);
        t.run();
        System.out.print("bat");
    }
}
