package week3rd;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {
    static class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer findCnt = map.getOrDefault(c, 0);
                map.put(c, ++findCnt);
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer findCnt = map.get(c);
                if (findCnt == 1)
                    return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // testcase1
        String str = "leetcode";
        int i = solution.firstUniqChar(str);
        System.out.println("i = " + i);

    }
}
