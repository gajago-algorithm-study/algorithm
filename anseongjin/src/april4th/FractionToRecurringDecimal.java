package april4th;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            Map<Integer, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            int number = numerator;
            int i = 0;
            int quotient = 0;
            int remainder = 0;

            while (true) {
                quotient = number / denominator;
                remainder = number % denominator;
                sb.append(quotient);
                if (remainder != 0) {
                    if (i == 0) sb.append(".");

                    Integer rem = map.get(remainder);

                    if (rem == null) map.put(remainder, i);
                    else {
                        sb.insert(2 + rem, "(");
                        sb.insert(i + 3, ")");
                        break;
                    }
                } else break;
                number = remainder * 10;
                i++;
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.fractionToDecimal(4, 333);
        System.out.println("s = " + s);
    }
}
