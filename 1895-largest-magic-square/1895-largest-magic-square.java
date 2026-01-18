class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Prefix sums
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        // Try sizes from large to small
        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {

                    int target = rowSum[i][j + k] - rowSum[i][j];
                    boolean isMagic = true;

                    // Check rows
                    for (int r = 0; r < k; r++) {
                        int sum = rowSum[i + r][j + k] - rowSum[i + r][j];
                        if (sum != target) {
                            isMagic = false;
                            break;
                        }
                    }

                    // Check columns
                    for (int c = 0; c < k && isMagic; c++) {
                        int sum = colSum[i + k][j + c] - colSum[i][j + c];
                        if (sum != target) {
                            isMagic = false;
                            break;
                        }
                    }

                    // Check diagonals
                    int d1 = 0, d2 = 0;
                    for (int d = 0; d < k && isMagic; d++) {
                        d1 += grid[i + d][j + d];
                        d2 += grid[i + d][j + k - 1 - d];
                    }

                    if (isMagic && d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }

        return 1;
    }
}
