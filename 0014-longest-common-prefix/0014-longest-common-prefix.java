class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb=new StringBuilder();
        String s1=strs[0];
        String s2=strs[strs.length-1];

        int l1=0,l2=0;

        while(l1<s1.length() && l2<s2.length() && 
                s1.charAt(l1)==s2.charAt(l2)){
            sb.append(s1.charAt(l1));
            l1++;
            l2++;
        }

        return sb.toString();
    }
}