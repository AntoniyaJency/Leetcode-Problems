import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        // assign ranks
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        // build answer
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}