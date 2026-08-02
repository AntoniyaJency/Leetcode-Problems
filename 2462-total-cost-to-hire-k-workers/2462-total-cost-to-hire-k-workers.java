class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int l = 0, r = n - 1;

        for (int i = 0; i < candidates && l <= r; i++) 
            left.add(costs[l++]);
        
        for (int i = 0; i < candidates && l <= r; i++) 
            right.add(costs[r--]);
        

        long total = 0;

        for (int i = 0; i < k; i++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                total += left.poll();
                if (l <= r) left.add(costs[l++]);
            } else {
                total += right.poll();
                if (l <= r) right.add(costs[r--]);
            }
        }

        return total;
    }
}