class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Build prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                        mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        // Step 2: Try all square sizes
        int maxLen = 0;

        for (int k = 1; k <= Math.min(m, n); k++) {
            boolean found = false;

            for (int i = k; i <= m; i++) {
                for (int j = k; j <= n; j++) {

                    int squareSum =
                            prefix[i][j]
                            - prefix[i - k][j]
                            - prefix[i][j - k]
                            + prefix[i - k][j - k];

                    if (squareSum <= threshold) {
                        maxLen = k;
                        found = true;
                        break;
                    }
                }

                if (found) break;
            }
        }

        return maxLen;
    }
}
