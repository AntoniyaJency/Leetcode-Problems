class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list=new ArrayList<>();

        if(s.length()<p.length()) return list;
        
        char[] sa=new char[26];
        char[] pa=new char[26];

        for(int i=0;i<p.length();i++){
            pa[p.charAt(i)-'a']++;
        }

        int k=p.length();

        for(int i=0;i<s.length();i++){
            sa[s.charAt(i)-'a']++;

            if(i>=k) sa[s.charAt(i-k)-'a']--;

            if(Arrays.equals(pa,sa)) list.add(i-k+1);


        }

        return list;


    }
}