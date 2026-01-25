class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];

        // Each column alone is valid
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        // Compare columns
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {

                boolean valid = true;

                // Check all rows
                for (int r = 0; r < n; r++) {
                    if (strs[r].charAt(j) > strs[r].charAt(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxKept = 0;
        for (int i = 0; i < m; i++) {
            if (dp[i] > maxKept) {
                maxKept = dp[i];
            }
        }

        return m - maxKept;
    }
}
