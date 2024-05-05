package april4th;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //case1
//        int[] arr = {2, 7, 11, 15};
//        int[] result = solution.twoSum(arr, 9);
        //case2
        int[] arr = {3, 2, 4};
        int[] result = solution.twoSum(arr, 6);
        for (int i : result) {
            System.out.println("i = " + i);
        }
    }
}
