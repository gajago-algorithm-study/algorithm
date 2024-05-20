package week2nd;

public class RotateList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            int size = getSize(head);
            if (size == 0) return head;
            int remainder = k % size;

            if (remainder != 0) {
                int n = size - remainder - 1;
                int i = 0;
                ListNode node = head;
                while (i < n) {
                    i++;
                    node = node.next;
                }

                ListNode temp = node.next;
                ListNode h = node.next;
                node.next = null;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = head;
                head = h;
            }
            return head;
        }

        public int getSize(ListNode head) {
            ListNode node = head;
            int size = 0;
            while (node != null) {
                size++;
                node = node.next;
            }
            return size;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode result = solution.rotateRight(l1, 2);
        System.out.println("result = " + result);
    }
}
