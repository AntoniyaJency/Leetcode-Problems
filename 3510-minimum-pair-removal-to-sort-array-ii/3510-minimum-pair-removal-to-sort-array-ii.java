import java.util.*;

class Solution {

    static class Pair {
        int i;
        long sum;
        Pair(int i, long sum) {
            this.i = i;
            this.sum = sum;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) arr[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }
        next[n - 1] = -1;

        // Count initial "bad" positions
        int bad = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) bad++;
        }

        if (bad == 0) return 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? a.i - b.i : Long.compare(a.sum, b.sum)
        );

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(i, arr[i] + arr[i + 1]));
        }

        int ops = 0;

        while (bad > 0) {

            Pair p = pq.poll();
            int i = p.i;
            int j = (i >= 0 ? next[i] : -1);

            if (j == -1 || !alive[i] || !alive[j]) continue;
            if (arr[i] + arr[j] != p.sum) continue; // stale

            // Remove old bad counts
            if (prev[i] != -1 && arr[prev[i]] > arr[i]) bad--;
            if (arr[i] > arr[j]) bad--;
            if (next[j] != -1 && arr[j] > arr[next[j]]) bad--;

            // Merge i and j
            arr[i] = arr[i] + arr[j];
            alive[j] = false;

            int nj = next[j];
            next[i] = nj;
            if (nj != -1) prev[nj] = i;

            // Add new bad counts
            if (prev[i] != -1 && arr[prev[i]] > arr[i]) bad++;
            if (next[i] != -1 && arr[i] > arr[next[i]]) bad++;

            // Add new adjacent sums
            if (prev[i] != -1) {
                int pi = prev[i];
                pq.offer(new Pair(pi, arr[pi] + arr[i]));
            }
            if (next[i] != -1) {
                int ni = next[i];
                pq.offer(new Pair(i, arr[i] + arr[ni]));
            }

            ops++;
        }

        return ops;
    }
}
