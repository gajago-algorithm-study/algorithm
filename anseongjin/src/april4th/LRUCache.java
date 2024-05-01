package april4th;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        if (tail.key == key) {
            tail = tail.prev;
        }

        Node node = map.get(key);
        removeNode(node);
        addNodeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        } else {
            if (map.isEmpty()) {
                Node node = new Node(key, value);
                head = new Node(key, value);
                tail = new Node(key, value);
                head.next = tail;
                tail.prev = head;
                map.put(key, node);
                addNodeToHead(node);
            } else {
                if (map.size() == capacity) {
                    map.remove(tail.prev.key);
                    removeNode(tail.prev);
                }
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addNodeToHead(newNode);
            }
        }
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null && next == null) {
            prev.next = null;
        } else if (prev == null && next != null) {
            next.prev = null;
        } else if (prev != null && next != null) {
            prev.next = next;
            next.prev = prev;
        }
    }

    private void addNodeToHead(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int get11 = cache.get(1);
        System.out.println("get11 = " + get11);
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
