class Solution {
    public String largestGoodInteger(String num) {

        String ans = "";

        for (int i = 0; i <= num.length() - 3; i++) {

            char a = num.charAt(i);
            char b = num.charAt(i + 1);
            char c = num.charAt(i + 2);

            // check if all three are same
            if (a == b && b == c) {
                String curr = "" + a + b + c;

                // update answer if bigger
                if (ans.equals("") || curr.compareTo(ans) > 0) {
                    ans = curr;
                }
            }
        }

        return ans;
    }
}
