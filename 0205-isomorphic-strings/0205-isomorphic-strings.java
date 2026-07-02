class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] freq1=new int[256];
        int[] freq2=new int[256];
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(freq1[sc]!=freq2[tc]) return false;
            freq1[sc]=i+1;
            freq2[tc]=i+1;
        }

        return true;
        
    } 
}