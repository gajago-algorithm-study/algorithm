package week2nd;

public class RemoveLinkedListElements {
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = head;
            ListNode prev = head;
            while (node != null) {
                if (node.val == val) {
                    if (node == head) {
                        head = node.next;
                    } else {
                        prev.next = node.next;
                    }
                } else {
                    prev = node;
                }
                node = node.next;
            }
            return head;
        }
    }


    public static void main(String[] args) {

        Solution solution = new Solution();

        // testcase1
//        ListNode l62 = new ListNode(6);
//        ListNode l5 = new ListNode(5, l62);
//        ListNode l4 = new ListNode(4, l5);
//        ListNode l3 = new ListNode(3, l4);
//        ListNode l61 = new ListNode(6, l3);
//        ListNode l2 = new ListNode(2, l61);
//        ListNode l1 = new ListNode(1, l2);
//
//        solution.removeElements(l1, 6);
//        System.out.println("l1 = " + l1);

        // testcase2
//        ListNode l73 = new ListNode(7);
//        ListNode l72 = new ListNode(7, l73);
//        ListNode l71 = new ListNode(7, l72);
//        ListNode l70 = new ListNode(7, l71);
//
//        ListNode listNode = solution.removeElements(l70, 7);
//        System.out.println("listNode = " + listNode);

        // testcase3
        ListNode l11 = new ListNode(1);
        ListNode l21 = new ListNode(2, l11);
        ListNode l20 = new ListNode(2, l21);
        ListNode l10 = new ListNode(1, l20);

        ListNode listNode = solution.removeElements(l10, 2);
        System.out.println("listNode = " + listNode);
    }
}
