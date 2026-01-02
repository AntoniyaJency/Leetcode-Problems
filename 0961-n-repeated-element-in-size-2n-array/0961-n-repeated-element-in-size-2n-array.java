import java.util.*;

class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n)) {
                return n;   // repeated number found
            }
            set.add(n);
        }

        return -1; // will never happen
    }
}
