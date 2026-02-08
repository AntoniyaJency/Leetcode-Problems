import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int maxOnLine = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                // normalize sign (so (-1, -1) and (1, 1) are same slope)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;  // vertical line
                } else if (dy == 0) {
                    dx = 1;  // horizontal line
                }

                String key = dx + "," + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
                maxOnLine = Math.max(maxOnLine, map.get(key));
            }

            ans = Math.max(ans, maxOnLine + 1); // +1 for anchor point
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
