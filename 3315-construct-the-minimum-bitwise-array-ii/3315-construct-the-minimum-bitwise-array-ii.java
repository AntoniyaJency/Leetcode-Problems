class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int target = nums.get(i);
            
            // If target is 2, no solution exists based on the bitwise property
            if (target == 2) {
                ans[i] = -1;
                continue;
            }
            
            // Find the length of the trailing sequence of 1s
            // We want to turn off the highest bit in that trailing sequence
            // Example: 11 (1011) -> trailing ones are at positions 0 and 1.
            // Turning off bit at pos 1 gives 1001 (9). 9 | 10 = 11.
            int temp = target;
            int count = 0;
            
            // Count how many consecutive 1s are at the end
            while ((temp & 1) == 1) {
                temp >>= 1;
                count++;
            }
            
            // The bit we want to turn off is at (count - 1)
            // ans[i] = target ^ (1 << (count - 1))
            ans[i] = target ^ (1 << (count - 1));
        }
        
        return ans;
    }
}