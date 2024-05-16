package april4th;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertArrTo2d {
    static class Solution {
        public List<List<Integer>> findMatrix(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.putIfAbsent(num, 0);
                Integer n = map.get(num);
                map.put(num, ++n);
            }

            while (!map.isEmpty()) {
                List<Integer> list = map.entrySet().stream()
                        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed()))
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());
                result.add(list);
                map = map.entrySet().stream()
                        .filter(it -> it.getValue() - 1 > 0)
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() - 1));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
//        List<List<Integer>> matrix = solution.findMatrix(nums);
//        System.out.println("matrix = " + matrix);

        // testcase2
        int[] nums2 = { 9,8,8,4,9,8,8,3,9 };

        List<List<Integer>> matrix = solution.findMatrix(nums2);
        System.out.println("matrix = " + matrix);
    }
}
