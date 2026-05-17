import java.util.*;

class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int i = q.poll();

            // if we reach 0
            if (arr[i] == 0) {
                return true;
            }

            // jump forward
            int forward = i + arr[i];
            if (forward < arr.length && !visited[forward]) {
                q.add(forward);
                visited[forward] = true;
            }

            // jump backward
            int backward = i - arr[i];
            if (backward >= 0 && !visited[backward]) {
                q.add(backward);
                visited[backward] = true;
            }
        }

        return false;
    }
}