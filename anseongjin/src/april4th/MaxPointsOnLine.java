package april4th;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaxPointsOnLine {
    static class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n <= 2) return n;
            int result = 0;
            HashMap<String, Set<String>> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {

                for (int j = i + 1; j < n; j++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];

                    double slope;
                    double yi;

                    if (p2[0] - p1[0] == 0) {
                        slope = Double.POSITIVE_INFINITY;
                        yi = p1[0];
                    } else {
                        slope = ((double)p2[1] - p1[1]) / (p2[0] - p1[0]);
                        yi = p1[1] - p1[0] * slope;
                    }

                    String key = String.format("%s_%s", slope, yi);
                    Set<String> sets = mp.get(key);
                    if (sets != null) {
                        sets.add(String.format("%d_%d", p1[0], p1[1]));
                        sets.add(String.format("%d_%d", p2[0], p2[1]));
                        result = Math.max(result, sets.size());
                    } else {
                        sets = new HashSet<>();
                        sets.add(String.format("%d_%d", p1[0], p1[1]));
                        sets.add(String.format("%d_%d", p2[0], p2[1]));
                        mp.put(key, sets);
                        result = Math.max(result, sets.size());
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 1}, {2,2}, {3, 3}};
        int i = solution.maxPoints(arr);
        System.out.println("i = " + i);

    }
}
