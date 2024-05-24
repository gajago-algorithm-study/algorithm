package week3rd;

public class DesignFrontMiddleBackQueue {
    static class FrontMiddleBackQueue {

        static class Node {
            int val;

            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        int size;
        Node head;
        Node tail;

        public FrontMiddleBackQueue() {
            size = 0;
            head = null;
            tail = null;
        }

        public void pushFront(int val) {
            Node node = new Node(val);
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }
            size++;
        }

        public void pushMiddle(int val) {
            Node node = new Node(val);
            if (size == 0) {
                head = node;
                tail = node;
                size++;
            } else {
                int index = size / 2;
                int cnt = 0;

                Node n = head;
                while (cnt < index) {
                    n = n.next;
                    cnt++;
                }

                Node prev = n.prev;
                if (prev == null) {
                    pushFront(val);
                } else {
                    node.next = n;
                    node.prev = prev;

                    prev.next = node;
                    n.prev = node;
                    size++;
                }
            }

        }

        public void pushBack(int val) {
            Node node = new Node(val);

            if (size == 0) {
                head = node;
                tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public int popFront() {
            if (size == 0) return -1;
            else {
                int result = head.val;
                if (head.next != null && head.next != tail) {
                    Node temp = head;
                    head = head.next;
                    head.prev = null;
                    temp.next = null;
                } else if (head.next == tail) {
                    head.next = null;
                    tail.prev = null;
                    head = tail;
                } else {
                    head = null;
                    tail = null;
                }
                size--;
                return result;
            }
        }

        public int popMiddle() {
            if (size == 0) return -1;
            else {

                int index = (size - 1) / 2;
                int cnt = 0;

                Node n = head;
                while (cnt < index) {
                    n = n.next;
                    cnt++;
                }

                int result = 0;
                Node prev = n.prev;
                if (prev == null) {
                    return popFront();
                } else {
                    result = n.val;
                    Node next = n.next;
                    prev.next = next;
                    next.prev = prev;
                    n.prev = null;
                    n.next = null;
                    size--;
                    return result;
                }
            }
        }

        public int popBack() {
            if (size == 0) return -1;
            else {
                int result = tail.val;
                if (tail.prev == null) {
                    head = null;
                    tail = null;
                } else if (tail.prev == head) {
                    head.next = null;
                    tail.prev = null;
                    tail = head;
                } else {
                    Node temp = tail;
                    tail = tail.prev;
                    tail.next = null;
                    temp.prev = null;
                }
                size--;
                return result;
            }
        }


        public void printAllNodes() {
            Node node = head;
            while (node != null) {
                System.out.println("Node([" + node + "]value=" + node.val + " prev=" + node.prev + ", next=" + node.next + "])");

                node = node.next;
            }
            System.out.println("head: " + head);
            System.out.println("tail: " + tail);
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
        // testcase1
        obj.pushFront(1);
        obj.pushBack(2);
        obj.pushMiddle(3);
        obj.pushMiddle(4);

        int pop1 = obj.popFront();
        System.out.println("pop1 = " + pop1);

        int pop2 = obj.popMiddle();
        System.out.println("pop2 = " + pop2);

        int pop3 = obj.popMiddle();
        System.out.println("pop3 = " + pop3);

        int pop4 = obj.popBack();
        System.out.println("pop4 = " + pop4);

        int pop5 = obj.popFront();
        System.out.println("pop5 = " + pop5);

        // testcase2
//        obj.pushMiddle(1);
//        obj.pushMiddle(2);
//        obj.pushMiddle(3);
//        obj.printAllNodes();
//
//        int pop1 = obj.popMiddle();
//        System.out.println("pop1 = " + pop1);
//        obj.printAllNodes();
//
//        int pop2 = obj.popMiddle();
//        System.out.println("pop2 = " + pop2);
//
//        int pop3 = obj.popMiddle();
//        System.out.println("pop3 = " + pop3);
//        obj.printAllNodes();

    }
}
