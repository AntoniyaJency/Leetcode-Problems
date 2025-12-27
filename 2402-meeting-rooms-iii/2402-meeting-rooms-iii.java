import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min heap of free rooms (lowest room number first)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            freeRooms.add(i);
        }

        // Min heap of busy rooms
        // Sorted by:
        // 1) earliest end time
        // 2) lowest room number (tie-breaker)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                return Long.compare(a[1], b[1]);
            }
        );

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free all rooms that are done before current meeting starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            int room;
            long finishTime;

            if (!freeRooms.isEmpty()) {
                // Assign lowest available room
                room = freeRooms.poll();
                finishTime = end;
            } else {
                // Delay meeting
                long[] earliest = busyRooms.poll();
                room = (int) earliest[1];
                finishTime = earliest[0] + duration;
            }

            busyRooms.add(new long[]{finishTime, room});
            count[room]++;
        }

        // Find room with maximum meetings
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }

        return result;
    }
}
