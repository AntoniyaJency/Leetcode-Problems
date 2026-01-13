class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long count = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }

        // add last zero block if exists
        result += count * (count + 1) / 2;

        return result;
    }
}
