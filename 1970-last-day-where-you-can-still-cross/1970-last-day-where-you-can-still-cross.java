import java.util.*;

class Solution {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = row * col;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(mid, row, col, cells)) {
                ans = mid;
                left = mid + 1;   // try later day
            } else {
                right = mid - 1; // try earlier day
            }
        }

        return ans;
    }

    private boolean canCross(int day, int row, int col, int[][] cells) {
        int[][] grid = new int[row][col];

        // Mark flooded cells
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1; // water
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        // Add all land cells from top row
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                q.add(new int[]{0, j});
                visited[0][j] = true;
            }
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // Reached bottom row
            if (x == row - 1) {
                return true;
            }

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!visited[nx][ny] && grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return false;
    }
}
