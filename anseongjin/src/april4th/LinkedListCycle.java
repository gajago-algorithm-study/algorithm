package april4th;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    static class Solution {
        public boolean hasCycle(ListNode head) {
            Map<String, Integer> map = new HashMap<>();
            boolean result = false;
            ListNode n1 = head;

            while (n1 != null) {
                String s = n1.toString();
                map.computeIfAbsent(s, k -> 0);
                Integer i = map.get(s);
                if (i > 0) {
                    result = true;
                    break;
                } else {
                    map.put(s, ++i);
                }
                n1 = n1.next;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // example1
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        Solution solution = new Solution();
        boolean result = solution.hasCycle(node0);
        System.out.println("Output: " + result);


        // example2
//        ListNode node0 = new ListNode(1);
//        ListNode node1 = new ListNode(2);
//
//        node0.next = node1;
//        node1.next = node0;
//
//        Solution solution = new Solution();
//        boolean result = solution.hasCycle(node0);
//        System.out.println("Output: " + result);

        // example3
//        ListNode node0 = new ListNode(1);
//        Solution solution = new Solution();
//        boolean result = solution.hasCycle(node0);
//        System.out.println("Output: " + result);
    }
}
