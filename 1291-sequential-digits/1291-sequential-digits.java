class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String s = "123456789";
        
        int n = s.length();
        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);
                int num = Integer.parseInt(sub);
                if (num >= low && num <= high) result.add(num);
            }
        }
        return result;
    }
}