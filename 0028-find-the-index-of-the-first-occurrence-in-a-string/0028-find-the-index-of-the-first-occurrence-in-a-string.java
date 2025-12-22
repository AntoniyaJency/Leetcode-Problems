class Solution {
    public int strStr(String haystack, String needle) {

        int h = haystack.length();
        int n = needle.length();

        // loop till remaining length is enough
        for (int i = 0; i <= h - n; i++) {
            int j = 0;

            // check character by character
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // if full needle matched
            if (j == n) {
                return i;
            }
        }

        return -1;
    }
}
