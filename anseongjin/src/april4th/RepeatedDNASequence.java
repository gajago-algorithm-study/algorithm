package april4th;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequence {
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String substring = s.substring(i, i + 10);
                Integer cnt = map.computeIfAbsent(substring, k -> 0);
                map.put(substring, ++cnt);
            }
            return map.entrySet().stream().filter(it -> {
                Integer value = it.getValue();
                return it.getValue() >= 2;
            }).map(Map.Entry::getKey).collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // example1
        List<String> result1 = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println("result1 = " + result1);

        // example2
        List<String> result2 = solution.findRepeatedDnaSequences("AAAAAAAAAAAAA");
        System.out.println("result2 = " + result2);
    }
}
