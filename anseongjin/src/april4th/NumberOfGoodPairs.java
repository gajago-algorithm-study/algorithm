package april4th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfGoodPairs {
    static class Solution {
        public int numIdenticalPairs(int[] nums) {
            int result = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.computeIfAbsent(num, k -> new ArrayList<>());
                List<Integer> integers = map.get(num);
                integers.add(i);
            }

            for (List<Integer> value : map.values()) {
                int size = value.size();
                if (size > 1) {
                    result += (size * (size - 1) / 2);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        //testcase1
        int[] nums = { 1, 2, 3, 1, 1, 3 };
        int result = solution.numIdenticalPairs(nums);
        System.out.println("result = " + result);

        //testcase2
        int[] nums2 = { 1, 1, 1, 1 };
        int result2 = solution.numIdenticalPairs(nums2);
        System.out.println("result2 = " + result2);
    }
}
