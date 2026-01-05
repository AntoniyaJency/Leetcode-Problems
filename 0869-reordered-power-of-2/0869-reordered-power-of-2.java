class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);

        for (int i = 0; i <= 30; i++) {
            int power = 1 << i;
            if (sortDigits(power).equals(target)) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        java.util.Arrays.sort(arr);
        return new String(arr);
    }
}
