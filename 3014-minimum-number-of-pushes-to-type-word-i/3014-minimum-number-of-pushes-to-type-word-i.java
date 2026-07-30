class Solution {
    public int minimumPushes(String word) {
        int press=0;
        for(int i=0;i<word.length();i++)
            press+=(i/8)+1;
        return press;
    }
}