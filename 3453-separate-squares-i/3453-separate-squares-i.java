class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = 0;

        for (int[] sq : squares) {
            low = Math.min(low, sq[1]);
            high = Math.max(high, sq[1] + sq[2]);
        }

        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double below = 0, above = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];
                double top = y + l;

                double belowHeight = Math.max(0, Math.min(mid, top) - y);
                double aboveHeight = Math.max(0, top - Math.max(mid, y));

                below += belowHeight * l;
                above += aboveHeight * l;
            }

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
