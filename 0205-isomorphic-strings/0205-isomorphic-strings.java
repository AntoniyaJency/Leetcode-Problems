class Solution {
    public boolean isIsomorphic(String s, String t) {
        //if(s.length()!=t.length()) return false;
        Map<Character,Character> m1=new HashMap<>();
        Map<Character,Character> m2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(m1.containsKey(sc))
                if(m1.get(sc)!=tc) return false;
            if(m2.containsKey(tc))
                if(m2.get(tc)!=sc) return false;
            m1.put(sc,tc);
            m2.put(tc,sc);
            
        }

        return true;
} 
}