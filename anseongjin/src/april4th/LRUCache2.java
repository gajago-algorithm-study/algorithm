package april4th;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int get1 = cache.get(1);
        System.out.println("get1 = " + get1);
        cache.put(3, 3);
        int get21 = cache.get(2);
        System.out.println("get21 = " + get21);
        cache.put(4, 4);
        int get12 = cache.get(1);
        System.out.println("get12 = " + get12);
        int get31 = cache.get(3);
        System.out.println("get31 = " + get31);
        int get41 = cache.get(4);
        System.out.println("get41 = " + get41);
    }
}
