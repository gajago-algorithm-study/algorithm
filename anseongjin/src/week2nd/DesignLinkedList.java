package week2nd;

public class DesignLinkedList {
    static class MyLinkedList {
        static class ListNode {
            int val;
            ListNode next;

            public ListNode() {}
            public ListNode(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return "ListNode{" +
                        "val=" + val +
                        ", next=" + next +
                        '}';
            }
        }
        int size;
        ListNode head;

        public MyLinkedList() {
        }

        public int get(int index) {
            ListNode node = getNode(index);
            if (node == null) {
                return -1;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
        }

        public void addAtTail(int val) {

            if (head == null) {
                addAtHead(val);
                return;
            }
            ListNode node = head;
            ListNode newNode = new ListNode(val);
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index == 0 ) {
                addAtHead(val);
                return;
            } else {
                ListNode prevNode = getNode(index - 1);
                if (prevNode != null) {
                    ListNode newNode = new ListNode(val);
                    newNode.next = prevNode.next;
                    prevNode.next = newNode;
                }
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index == 0) {
                ListNode temp = head;
                head = head.next;
                temp.next = null;
            } else {
                ListNode node = getNode(index);
                ListNode prevNode = getNode(index - 1);
                if (prevNode != null && node != null) {
                    prevNode.next = node.next;
                } else {
                    return;
                }
            }
            size--;
        }


        private ListNode getNode(int index) {
            if (size - 1 < index) {
                return null;
            }
            int cnt = 0;
            ListNode node = head;
            while (cnt != index) {
                cnt++;
                node = node.next;
            }
            return node;
        }

        public void printAllNodes() {
            ListNode node = head;
            while (node != null) {
                System.out.println("node = " + node);
                node = node.next;
            }
        }

        @Override
        public String toString() {
            return "MyLinkedList{" +
                    "head=" + head +
                    '}';
        }
    }

    public static void main(String[] args) {
        // testcase1
//        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(1);
//        list.addAtTail(3);
//        list.addAtIndex(1, 2);
//        int get11 = list.get(1);
//        System.out.println("list.get(1): " + get11);
//        list.deleteAtIndex(1);
//        list.get(1);
//        int get12 = list.get(1);
//        System.out.println("list.get(1): " + get12);
//        list.printAllNodes();

        // testcase2
//        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(7);
//        list.addAtHead(2);
//        list.addAtHead(1);
//        list.addAtIndex(3, 0);
//        list.deleteAtIndex(2);
//        list.addAtHead(6);
//        list.addAtTail(4);
//        list.get(4);
//        list.addAtHead(4);
//        list.addAtIndex(5, 0);
//        list.addAtHead(6);
//        System.out.println("list = " + list);

        // testcase3
//        MyLinkedList list = new MyLinkedList();
//        list.addAtTail(1);
//        list.get(0);

        // testcase4
//        MyLinkedList list = new MyLinkedList();
//        list.addAtHead(4);
//        list.get(1);
//        list.addAtHead(1);
//        list.addAtHead(5);
//        list.deleteAtIndex(3);
//        list.addAtHead(7);
//        int get31 = list.get(3);
//        System.out.println("get31 = " + get31);
//        list.printAllNodes();

        // testcase5
//        MyLinkedList list = new MyLinkedList();
//        list.addAtTail(1);
//        list.addAtTail(3);
//        int i = list.get(1);
//        System.out.println("i = " + i);

        // testcase6
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(3 ,2);
        list.printAllNodes();
    }
}
