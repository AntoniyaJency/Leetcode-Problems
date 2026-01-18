class Solution {
    int[][] grid;
    int m, n;
    final int INF = (int) 1e9;

    public int minimumSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        // ✅ Critical edge case
        int ones = 0;
        for (int[] row : grid)
            for (int v : row)
                if (v == 1) ones++;

        if (ones == 3) return 3;

        int ans = INF;

        // Case 1: Three vertical rectangles
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = c1 + 1; c2 < n; c2++) {
                ans = Math.min(ans,
                        area(0, m - 1, 0, c1) +
                        area(0, m - 1, c1 + 1, c2) +
                        area(0, m - 1, c2 + 1, n - 1));
            }
        }

        // Case 2: Three horizontal rectangles
        for (int r1 = 0; r1 < m; r1++) {
            for (int r2 = r1 + 1; r2 < m; r2++) {
                ans = Math.min(ans,
                        area(0, r1, 0, n - 1) +
                        area(r1 + 1, r2, 0, n - 1) +
                        area(r2 + 1, m - 1, 0, n - 1));
            }
        }

        // Case 3: Vertical then horizontal
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++) {
                ans = Math.min(ans,
                        area(0, m - 1, 0, c) +
                        area(0, r, c + 1, n - 1) +
                        area(r + 1, m - 1, c + 1, n - 1));
            }
        }

        // Case 4: Horizontal then vertical
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                ans = Math.min(ans,
                        area(0, r, 0, n - 1) +
                        area(r + 1, m - 1, 0, c) +
                        area(r + 1, m - 1, c + 1, n - 1));
            }
        }

        return ans;
    }

    int area(int r1, int r2, int c1, int c2) {
        if (r1 > r2 || c1 > c2) return INF;

        int minR = INF, maxR = -1, minC = INF, maxC = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (maxR == -1) return INF;

        return (maxR - minR + 1) * (maxC - minC + 1);
    }
}
