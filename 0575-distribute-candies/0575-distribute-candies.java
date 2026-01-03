import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candyType) {

        HashSet<Integer> set = new HashSet<>();

        // store unique candy types
        for (int candy : candyType) {
            set.add(candy);
        }

        int maxCandiesSheCanEat = candyType.length / 2;

        return Math.min(set.size(), maxCandiesSheCanEat);
    }
}
