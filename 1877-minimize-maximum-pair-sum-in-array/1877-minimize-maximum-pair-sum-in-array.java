import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxSum = 0;
        int i = 0, j = nums.length - 1;

        while (i < j) {
            int pairSum = nums[i] + nums[j];
            if (pairSum > maxSum) {
                maxSum = pairSum;
            }
            i++;
            j--;
        }

        return maxSum;
    }
}
