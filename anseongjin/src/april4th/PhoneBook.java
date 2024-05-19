package april4th;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    static class Solution {
        public boolean solution(String[] phone_book) {
            for (int i = 0; i < phone_book.length - 1; i++) {
                for (int j = i + 1; j < phone_book.length; j++) {
                    String s1 = phone_book[i];
                    String s2 = phone_book[j];
                    if (s1.length() < s2.length() && s2.startsWith(s1)) return false;
                    else if (s2.length() < s1.length() && s1.startsWith(s2)) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // testcase1
        String[] arr = { "119", "97674223", "1195524421" };
        boolean solution1 = solution.solution(arr);
        System.out.println("solution1 = " + solution1);

        // testcase2
        String[] arr2 = { "123","456","789" };
        boolean solution2 = solution.solution(arr2);
        System.out.println("solution2 = " + solution2);

        // testcase3
        String[] arr3 = { "12","123","1235","567","88" };
        boolean solution3 = solution.solution(arr3);
        System.out.println("solution3 = " + solution3);
    }
}
