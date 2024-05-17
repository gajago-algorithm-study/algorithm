package week2nd;

public class ReverseLinkedList {
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
        public ListNode reverseList(ListNode head) {
            ListNode node = head;
            ListNode prev = head;
            while (node != null) {
                ListNode next = node.next;
                if (node == head) {
                    head.next = null;
                } else {
                    node.next = prev;
                    prev = node;
                }
                node = next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        ListNode listNode = solution.reverseList(l1);
        System.out.println("listNode = " + listNode);

    }
}
