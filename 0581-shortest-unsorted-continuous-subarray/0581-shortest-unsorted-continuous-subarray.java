class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int start = -1, end = -1;

        // Step 1: find first unsorted index from left
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                start = i;
                break;
            }
        }

        // If already sorted
        if (start == -1) {
            return 0;
        }

        // Step 2: find first unsorted index from right
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                end = i;
                break;
            }
        }

        // Step 3: find min and max in subarray
        int min = nums[start], max = nums[start];
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }

        // Step 4: extend start to left
        while (start > 0 && nums[start - 1] > min) {
            start--;
        }

        // Step 5: extend end to right
        while (end < n - 1 && nums[end + 1] < max) {
            end++;
        }

        return end - start + 1;
    }
}
