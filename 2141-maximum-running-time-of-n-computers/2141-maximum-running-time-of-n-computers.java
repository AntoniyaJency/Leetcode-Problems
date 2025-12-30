class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long left = 0, right = 0;

        // Upper bound = total battery power / n
        for (int b : batteries) right += b;
        right /= n;

        while (left < right) {
            long mid = (left + right + 1) / 2;

            if (canRun(mid, n, batteries))
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }

    private boolean canRun(long time, int n, int[] batteries) {
        long power = 0;
        for (int b : batteries) {
            power += Math.min(b, time);
        }
        return power >= n * time;
    }
}
