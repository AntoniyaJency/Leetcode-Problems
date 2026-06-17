import java.util.*;

class Solution {
    public char processStr(String s, long k) {
        long len = 0;

        // 🔹 Step 1: Compute final length
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                len++;
            } else if (c == '*') {
                if (len > 0) len--;
            } else if (c == '#') {
                len *= 2;
            } else if (c == '%') {
                // reverse → length unchanged
            }

            // optional safety cap (since max is 1e15)
            if (len > 1e15) len = (long)1e15;
        }

        // ❌ out of bounds
        if (k >= len) return '.';

        // 🔹 Step 2: Traverse backwards
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {
                len--;
                if (k == len) return c;
            } 
            else if (c == '*') {
                // forward: len--
                // backward: len++
                len++;
            } 
            else if (c == '#') {
                // forward: len *= 2
                // backward: len /= 2
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } 
            else if (c == '%') {
                // reverse mapping
                k = len - 1 - k;
            }
        }

        return '.';
    }
}