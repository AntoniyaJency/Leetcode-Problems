import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        // If k is 1, difference is always 0
        if (k == 1) return 0;

        // Sort the array
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        // Check each window of size k
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
