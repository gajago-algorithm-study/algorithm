package april4th;

import java.util.HashMap;
import java.util.Map;

public class Clothes {
    static class Solution {
        public int solution(String[][] clothes) {
            Map<String, Integer> map = new HashMap<>();
            for (String[] c : clothes) {
                map.putIfAbsent(c[1], 0);
                Integer cnt = map.get(c[1]);
                map.put(c[1], ++cnt);
            }
            int result = 1;
            for (Integer value : map.values()) {
                result *= (value + 1);
            }
            return result - 1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        // testcase1
        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution.solution(arr);
        System.out.println("result = " + result);

        // testcase2
        String[][]arr2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        int result2 = solution.solution(arr2);
        System.out.println("result2 = " + result2);
    }
}
