class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        // count letters
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }

        // calculate answer
        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}