import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long MOD = 1_000_000_007;

        // Add boundary fences
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        v.add(1);

        for (int x : hFences) h.add(x);
        for (int x : vFences) v.add(x);

        h.add(m);
        v.add(n);

        // Sort fences
        Collections.sort(h);
        Collections.sort(v);

        // All possible horizontal distances
        Set<Integer> hDist = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hDist.add(h.get(j) - h.get(i));
            }
        }

        // All possible vertical distances
        Set<Integer> vDist = new HashSet<>();
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                vDist.add(v.get(j) - v.get(i));
            }
        }

        // Find largest common distance
        int maxSide = 0;
        for (int d : hDist) {
            if (vDist.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == 0) return -1;

        long area = (long) maxSide * maxSide;
        return (int) (area % MOD);
    }
}
