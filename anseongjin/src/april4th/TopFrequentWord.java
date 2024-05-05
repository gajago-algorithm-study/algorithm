package april4th;

import java.util.*;
import java.util.stream.Collectors;

public class TopFrequentWord {
    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.computeIfAbsent(word, x -> 0);
                map.put(word, map.get(word) + 1);
            }
//            return map.entrySet().stream()
//                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
////                    .sorted(Map.Entry.comparingByKey())
//                    .limit(k)
//                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                    .map(Map.Entry::getKey)
//                    .collect(Collectors.toList());

            return map.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
                            .thenComparing(Map.Entry::getKey))
                    .limit(k)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
//            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
//
//            // Value를 기준으로 내림차순 정렬
//            list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // case1
        String[] arr = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> strings = solution.topKFrequent(arr, 4);

        //case2
//        String[] arr = {"i","love","leetcode","i","love","coding"};
//        List<String> strings = solution.topKFrequent(arr, 2);
        System.out.println("strings = " + strings);
    }
}
