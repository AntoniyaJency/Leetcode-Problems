class Solution {
    public int maxTwoEvents(int[][] events) {
        // 1. Sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        // 2. Suffix max array
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        int answer = 0;

        // 3. Try each event
        for (int i = 0; i < n; i++) {
            int value = events[i][2];
            int nextIndex = findNext(events, events[i][1] + 1);

            if (nextIndex < n) {
                value += suffixMax[nextIndex];
            }

            answer = Math.max(answer, value);
        }

        return answer;
    }

    // Binary search for first event with start >= target
    private int findNext(int[][] events, int target) {
        int low = 0, high = events.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] < target)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}
