class Solution {
    public int[] countBits(int n) {
        int[] val = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            val[i] = val[i >> 1] + (i & 1);
        }

        return val;
    }
}