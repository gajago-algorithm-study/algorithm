package april4th;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    static class Solution {

        private final int[] ROMAN_INTEGER = { 1, 5, 10, 50, 100, 500, 1000 };
        enum ROMAN_SYMBOL { I, V, X, L, C, D, M };
        Map<String, Integer> map = new HashMap<>();

        public int romanToInt(String s) {
            Map<String, Integer> map = new HashMap<>();
            map.put("I", 1);
            map.put("V", 5);
            map.put("X", 10);
            map.put("L", 50);
            map.put("C", 100);
            map.put("D", 500);
            map.put("M", 1000);
            int length = s.length();
            int i = 0;
            int result = 0;
            while (i < length) {
                Integer cur = map.get(String.valueOf(s.charAt(i)));
                if (i < length - 1 && cur < map.get(String.valueOf(s.charAt(i + 1)))) {
                    result -= cur;
                } else {
                    result += cur;
                }
                i++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.romanToInt("MCMXCIV");
        System.out.println("i = " + i);
    }
}
