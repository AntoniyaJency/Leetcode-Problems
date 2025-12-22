import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        // Split by slash
        String[] parts = path.split("/");

        // Stack to store folders
        Stack<String> stack = new Stack<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                // ignore empty or current directory
                continue;
            }

            if (part.equals("..")) {
                // go back one directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // valid directory name
                stack.push(part);
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If empty, return root
        return result.length() == 0 ? "/" : result.toString();
    }
}
