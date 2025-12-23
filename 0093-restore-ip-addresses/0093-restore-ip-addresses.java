import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0, "");
        return result;
    }

    void backtrack(String s, int index, int parts, String current) {
        // If 4 parts formed and string fully used
        if (parts == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1)); // remove last dot
            return;
        }

        // If too many parts or index crossed
        if (parts == 4 || index >= s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            // Leading zero check
            if (part.length() > 1 && part.startsWith("0")) break;

            int value = Integer.parseInt(part);
            if (value <= 255) {
                backtrack(s, index + len, parts + 1, current + part + ".");
            }
        }
    }
}
