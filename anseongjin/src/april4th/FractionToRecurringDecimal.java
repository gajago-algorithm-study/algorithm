package april4th;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            Map<Long, Integer> map = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            long number = Math.abs((long) numerator);
            long deno = Math.abs((long) denominator);
            int i = 0;
            long quotient = 0;
            long remainder = 0;
            boolean negativeFlag = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
            int pos = 0;

            if (negativeFlag) sb.append("-");

            while (true) {
                quotient = number / deno;
                remainder = number % deno;
                sb.append(quotient);

                if (remainder != 0) {
                    if (i == 0) {
                        String nn = quotient + "";
                        pos = nn.length();
                        sb.append(".");
                    }

                    Integer rem = map.get(remainder);

                    if (rem == null) map.put(remainder, i);
                    else {
                        int d = pos + 1;
                        if (negativeFlag) {
                            d++;
                        }
                        sb.insert(d + rem, "(");
                        sb.insert(i + d + 1, ")");
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
        String s = solution.fractionToDecimal(-2147483648, 1);
        System.out.println("s = " + s);
    }
}
