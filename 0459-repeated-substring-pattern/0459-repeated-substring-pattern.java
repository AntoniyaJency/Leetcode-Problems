class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        t = t.substring(1, t.length() - 1);
        return t.contains(s);
    }
}
