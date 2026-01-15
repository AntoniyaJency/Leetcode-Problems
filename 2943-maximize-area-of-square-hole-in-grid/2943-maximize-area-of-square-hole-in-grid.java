import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int h = maxConsecutive(hBars) + 1;
        int v = maxConsecutive(vBars) + 1;

        int side = Math.min(h, v);
        return side * side;
    }

    private int maxConsecutive(int[] arr) {
        Arrays.sort(arr);
        int maxLen = 1, curr = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }
        return maxLen;
    }
}
