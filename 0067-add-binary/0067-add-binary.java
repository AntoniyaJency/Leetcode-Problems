class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;   // last index of a
        int j = b.length() - 1;   // last index of b
        int carry = 0;            // carry for addition

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = carry;      // start with carry

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2); // store last bit
            carry = sum / 2;        // update carry
        }

        return result.reverse().toString();
    }
}
