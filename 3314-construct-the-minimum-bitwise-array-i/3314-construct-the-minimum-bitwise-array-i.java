import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            int found = -1;

            // Try all possible values of a
            for (int a = 0; a <= x; a++) {
                if ( (a | (a + 1)) == x ) {
                    found = a;
                    break;   // smallest found
                }
            }

            ans[i] = found;
        }

        return ans;
    }
}
