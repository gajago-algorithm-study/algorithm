package april4th;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {}
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
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = search(key);
        if (node == null)
            return -1;
        else{
            remove(node);
            addNodeAtHeadNext(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = search(key);
        Node newNode = new Node(key, value);
        if (node != null) {
            remove(node);
            addNodeAtHeadNext(newNode);
        } else {
            int size = map.size();
            if (capacity == size) {
                remove(tail.prev);
                addNodeAtHeadNext(newNode);
            } else if (capacity > size) {
                addNodeAtHeadNext(newNode);
            }
        }
    }

    private Node search(int key) {
        return map.get(key);
    }

    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(node.key);
    }

    private void addNodeAtHeadNext(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }

    private int size() {
        int size = 0;
        Node node = head;
        while (node.next != tail) {
            node = node.next;
            size++;
        }
        return size;
    }

    public void printAllNodes() {
        Node node = head;
        while (node != tail) {
            if (node != head)
                System.out.println("key: " + node.key + ", value: " + node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // testcase1
//        LRUCache cache = new LRUCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);
//        cache.put(3, 3);
//        cache.printAllNodes();

        // testcase2
//        LRUCache cache = new LRUCache(1);
//        cache.get(0);

        // testcase3
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);

    }
}
