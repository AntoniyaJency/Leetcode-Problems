class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            if (xor % 2 == 1) {   // check last bit
                count++;
            }
            xor = xor / 2;       // remove last bit
        }

        return count;
    }
}
