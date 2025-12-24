class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Sort capacities in ascending order
        Arrays.sort(capacity);

        int sum = 0;
        int count = 0;

        // Pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            count++;

            if (sum >= totalApples) {
                return count;
            }
        }

        return count; // always possible as per constraints
    }
}
