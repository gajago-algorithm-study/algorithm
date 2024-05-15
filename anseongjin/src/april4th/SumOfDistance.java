package april4th;

import java.util.*;

public class SumOfDistance {
    static class Solution {
        public long[] distance(int[] nums) {
            long[] result = new long[nums.length];

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                map.computeIfAbsent(num, k -> new ArrayList<>());
                List<Integer> indexes = map.get(num);
                indexes.add(i);
            }

            for (int i = 0; i < nums.length; i++) {
                long temp = 0;
                int num = nums[i];
                List<Integer> integers = map.get(num);
                if (integers.size() == 1)
                    result[i] = 0;
                else {
                    for (Integer it : integers) {
                        temp += Math.abs(i - it);
                    }
                    result[i] = temp;
                }
            }
            return result;
        }

        public long[] distance2(int[] nums) {
            long[] result = new long[nums.length];

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];

                map.computeIfAbsent(num, k -> new ArrayList<>());
                List<Integer> indexes = map.get(num);
                if (indexes.isEmpty()) {
                    result[i] = 0;
                } else {
                    for (Integer index : indexes) {
                        result[index] += Math.abs(index - i);
                        result[i] += Math.abs(i - index);
                    }

                }
                indexes.add(i);
            }
            return result;
        }

        public long[] distance3(int[] nums) {
            long[] result = new long[nums.length];
            long[] result1 = new long[nums.length];
            Map<Integer, Integer> countMap = new HashMap<>();
            Map<Integer, Integer> indexMap = new HashMap<>();
            Map<Integer, Integer> reverseMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                indexMap.putIfAbsent(num, -1);
                Integer prev = indexMap.get(num);
                if (prev == -1)
                    countMap.put(num, 1);
                else {
                    Integer prevCnt = countMap.get(num);
                    result1[i] = result1[prev] + prevCnt * (i - prev);
                    countMap.put(num, prevCnt + 1);
                }
                indexMap.put(num, i);
            }
            long[] result2 = new long[nums.length];
            countMap = new HashMap<>();
            for (int i = nums.length - 1; i >= 0; i--) {
                int num = nums[i];
                reverseMap.putIfAbsent(num, -1);
                Integer prev = reverseMap.get(num);
                if (prev == -1)
                    countMap.put(num, 1);
                else {
                    Integer prevCnt = countMap.get(num);
                    result2[i] = result2[prev] + prevCnt * (prev - i);
                    countMap.put(num, prevCnt + 1);
                }
                reverseMap.put(num, i);
            }
            for (int i = 0; i < nums.length; i++) {
                result[i] = result1[i] + result2[i];
            }
            return result;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = { 1,3,1,1,2 };
        long[] distance = solution.distance(arr);
        System.out.println("distance = " + Arrays.toString(distance));


        long[] distance3 = solution.distance3(arr);
        System.out.println("distance5 = " + Arrays.toString(distance3));
    }
}
