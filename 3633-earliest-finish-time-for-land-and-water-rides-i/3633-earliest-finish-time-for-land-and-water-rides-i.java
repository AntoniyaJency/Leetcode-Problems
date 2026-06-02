class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int ans = Integer.MAX_VALUE;

        // land -> water
        for (int i = 0; i < n; i++) {
            int landStart = landStartTime[i];
            int landEnd = landStart + landDuration[i];

            for (int j = 0; j < m; j++) {
                int waterStart = Math.max(landEnd, waterStartTime[j]);
                int waterEnd = waterStart + waterDuration[j];

                ans = Math.min(ans, waterEnd);
            }
        }

        // water -> land
        for (int j = 0; j < m; j++) {
            int waterStart = waterStartTime[j];
            int waterEnd = waterStart + waterDuration[j];

            for (int i = 0; i < n; i++) {
                int landStart = Math.max(waterEnd, landStartTime[i]);
                int landEnd = landStart + landDuration[i];

                ans = Math.min(ans, landEnd);
            }
        }

        return ans;
    }
}