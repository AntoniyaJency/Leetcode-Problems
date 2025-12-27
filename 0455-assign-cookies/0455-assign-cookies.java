import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child index
        int j = 0; // cookie index
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;   // child is content
                i++;
                j++;
            } else {
                j++;       // cookie too small
            }
        }

        return count;
    }
}
