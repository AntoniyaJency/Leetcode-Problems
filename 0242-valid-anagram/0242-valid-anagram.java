import java.util.Arrays;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] w1=s.toCharArray();
        char[] w2=t.toCharArray();
        Arrays.sort(w1);
        Arrays.sort(w2);
        if(Arrays.equals(w1,w2)){
            return true;
        }
        else return false;


        
    }
}