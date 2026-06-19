class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];

        int give = 1;
        int i = 0;

        while (candies > 0) {

            if (candies < give) {
                arr[i] += candies;
                break;
            }

            arr[i] += give;
            candies -= give;

            give++;
            i = (i + 1) % num_people; // move to next person
        }

        return arr;
    }
}