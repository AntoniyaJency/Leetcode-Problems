class Solution {
    public int lengthOfLastWord(String s) {
        String[] sn=s.split("\\s+");
        String res=sn[sn.length-1];
        return res.length();
    }
}