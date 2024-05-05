package april4th;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerToRoman {
    static class Solution {
        public String intToRoman(int num) {
            int number = num;
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = new HashMap<>();
            map.put("I", 1);
            map.put("IV", 4);
            map.put("V", 5);
            map.put("IX", 9);
            map.put("X", 10);
            map.put("XL", 40);
            map.put("L", 50);
            map.put("XC", 90);
            map.put("C", 100);
            map.put("CD", 400);
            map.put("D", 500);
            map.put("CM", 900);
            map.put("M", 1000);
            int i = 0;
            List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()).collect(Collectors.toList());
            while (i < collect.size()) {
                Map.Entry<String, Integer> entry = collect.get(i);
                Integer value = entry.getValue();
                if (number >= value) {
                    sb.append(entry.getKey());
                    number -= value;
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //case1
        String s = solution.intToRoman(3749);
        System.out.println("s = " + s);
        //case2
        String s1 = solution.intToRoman(1994);
        System.out.println("s1 = " + s1);
    }
}
