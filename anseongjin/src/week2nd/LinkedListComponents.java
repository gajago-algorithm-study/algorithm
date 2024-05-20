package week2nd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListComponents {
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
    }

    static class Solution {
        public int numComponents(ListNode head, int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, num);
            }
            int cnt = 0;
//            List<List<Integer>> ans = new ArrayList<>();
            ListNode node = head;

            while (node != null) {
                if (map.get(node.val) != null) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(node.val);
                    ListNode n = node.next;
                    if (n != null && map.get(n.val) != null) {
                        while (n != null && map.get(n.val) != null) {
//                            list.add(n.val);
                            n = n.next;
                        }
                    }
                    cnt++;
//                    ans.add(list);
                    node = n;
                } else {
                    node = node.next;
                }

            }
//            return ans.size();
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //testcase1
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode2 = new ListNode(2, listNode3);
//        ListNode listNode1 = new ListNode(1, listNode2);
//        ListNode listNode0 = new ListNode(0, listNode1);
//        int[] nums = { 0, 1, 3 };
//
//        int i = solution.numComponents(listNode0, nums);
//        System.out.println("i = " + i);

        //testcase2
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode0 = new ListNode(0, listNode1);
        int[] nums2 = { 0,3,1,4 };
        int result = solution.numComponents(listNode0, nums2);
        System.out.println("result = " + result);
    }
}
