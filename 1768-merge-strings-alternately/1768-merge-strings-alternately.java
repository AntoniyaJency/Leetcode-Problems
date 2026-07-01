class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int w1l=word1.length();
        int w2l=word2.length();

        for(int i=0;i<Math.max(w1l,w2l);i++){
            if(w1l>i)
            sb.append(word1.charAt(i));
            if(w2l>i)
            sb.append(word2.charAt(i));

        }

        return sb.toString();
        
    }
}